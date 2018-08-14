package com.eshore.wbtimer.core.rpc.net.jetty.server;

import com.eshore.wbtimer.core.thread.ExecutorRegistryThread;
import com.eshore.wbtimer.core.thread.TriggerCallbackThread;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.util.thread.ExecutorThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述: Jetty服务器
 *
 * @author Yangjinming
 * @create 2018-01-10 18:19
 */
public class JettyServer {

    private static final Logger logger = LoggerFactory.getLogger(JettyServer.class);

    private Server server;
    private Thread thread;
    public void start(final int port, final String ip, final String appName) throws Exception {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {

                // The Server
                server = new Server(new ExecutorThreadPool());  // 非阻塞

                // HTTP connector
                ServerConnector connector = new ServerConnector(server);
                if (ip!=null && ip.trim().length()>0) {
                    connector.setHost(ip);	// The network interface this connector binds to as an IP address or a hostname.  If null or 0.0.0.0, then bind to all interfaces.
                }
                connector.setPort(port);
                server.setConnectors(new Connector[]{connector});

                // 设置服务器请求成功回调
                HandlerCollection handlerc =new HandlerCollection();
                handlerc.setHandlers(new Handler[]{new JettyServerHandler()});
                server.setHandler(handlerc);

                try {
                    // 启动server（执行器启动）
                    server.start();
                    logger.info(">>>>>>>>>>> wbtimer-handler jetty server start success at port:{}.", port);

                    // 启动开始注册线程
                    ExecutorRegistryThread.getInstance().start(port, ip, appName);

                    // 启动触发器回调线程
                    TriggerCallbackThread.getInstance().start();

                    server.join();	// block until thread stopped
                    logger.info(">>>>>>>>>>> wbtimer-rpc server join success, netcon={}, port={}", JettyServer.class.getName(), port);
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                } finally {
                    //destroy();
                }
            }
        });
        thread.setDaemon(true);	// daemon, service jvm, user thread leave >>> daemon leave >>> jvm leave
        thread.start();
    }

    public void destroy() {

        // destroy Registry-Server
        ExecutorRegistryThread.getInstance().toStop();

        // destroy Callback-Server
        TriggerCallbackThread.getInstance().toStop();

        // destroy server
        if (server != null) {
            try {
                server.stop();
                server.destroy();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        if (thread.isAlive()) {
            thread.interrupt();
        }

        logger.info(">>>>>>>>>>> wbtimer-rpc server destroy success, netcon={}", JettyServer.class.getName());
    }
}
