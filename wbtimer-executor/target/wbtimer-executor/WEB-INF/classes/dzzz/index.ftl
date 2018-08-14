<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="baseInfo">
    <table class="table  table-condensed table-bordered"  id="infoTable">
        <tr class="active">
            <td colspan="4">证照信息项</td>
            <input type="hidden" id="license_item_code"  value="${r"${zzCode"}${r"}"}"/>
            <input type="hidden" id="sblsh"  value="${r"${sblsh"}${r"}"}"/>
            <input type="hidden" id="license_id"  value="${r"${license_id"}${r"}"}"/>
            <input type="hidden" id="isHalf"  value="${r"${isHalf"}${r"}"}"/>
        </tr>

        <s:if test="#request.isHalf=='false'">
     	<#list infoList as list>
     	  <tr>
              <td class="left">
     	        <#if list["isAllowNull"]=='false'>
     	          <span class="extra">*</span>
                </#if>
                  ${list["label"]}
              </td>
              <td>
     		 <#assign id=list["key"]>

     			<#switch list["typeCode"]>
                    <#case "textbox">
                        <#if list["itemIndex"]?exists>
				        <input type="text" id="${list["itemIndex"]}" name="${list["key"]}"  value="${r"${obj."}${list["itemIndex"]}${r"}"}"/>
                        <#else>
				          <input type="text" id="${list["key"]}" name="${list["key"]}"  value="${r"${obj."}${id}${r"}"}"/>
                        </#if>
                        <#break>
                    <#case "date_picker">
				     <input type="text" id="${list["key"]}" name="${list["key"]}" value="${r"${obj."}${id}${r"}"}" />
     			     <span class="glyphicon glyphicon-calendar"></span>
                        <#break>
                    <#case "select">
				      <select id="${list["key"]}_select" name="${list["key"]}">
                      </select>
					  <span class="glyphicon glyphicon-chevron-down"></span>
                        <#if list["isInitItem"]=='true'>
					    <input type="hidden" id="${list["key"]}"  value="${r"${obj."}${id}${r"}"}"/>
                        </#if>
                        <#break>
                    <#case "textarea">
				     <textarea id="${list["key"]}" name="${list["key"]}"  value="${r"${obj."}${id}${r"}"}"></textarea>
				      <#break>
                    <#case "table">
				     <table id="${list["key"]}">
                     </table>
                        <#break>
                    <#case "image">
			         <input type="hidden"  id="${list["key"]}_imageKey" name="imageKey_${list["key"]}"  value="${list["key"]}">
			         <a class="file" id="selectFile">选择文件
                         <input type="file" name="zzImage" id="${list["key"]}_image" onchange="uploadZzImg('${list["key"]}_image');" accept="image/jpeg,image/png,image/gif,image/bmp">
                     </a>
			    	 <div class="fix" style="display:none;">
                         <span class="label">&nbsp;</span>
                         <div style="text-align:left;" id="${list["key"]}">
                         </div>
                     </div>
                        <#break>
                    <#case "checkbox">
                        <#if list["isInitItem"]=='true'>
					    <input type="hidden" id="${list["key"]}_checkbox"  value="${r"${obj."}${id}${r"}"}"/>
                        </#if>
					   <div id="${list["key"]}_div">
                       </div>
                        <#break>
                    <#case "dynamic_table">
			         <table id="${list["key"]}">
                     </table>
                        <#break>
                    <#default>
                </#switch>
              </td>
          </tr>
        </#list>
            <tr>
                <td class="left">附件</td>
                <td>
                    <a class="file" id="selectFile">选择文件
                        <input type="file" name="file" id="file" onchange="upload();" accept="image/jpeg,image/png,image/gif,image/bmp">
                    </a>
                    <div class="fix" style="display:none;">
                        <span class="label">&nbsp;</span>
                        <div style="text-align:left;" id="imgFile">
                        </div>
                    </div>
                </td>
            </tr>
        </s:if>
        <s:else>
     	   <#list infoList as list>
     	  <tr>
              <td class="left">
                  ${list["label"]}
              </td>
              <td>
     		 <#assign id=list["key"]>

     			<#switch list["typeCode"]>
                    <#case "textbox">
                        <#if list["itemIndex"]?exists>
				        <input type="text" id="${list["itemIndex"]}" name="${list["key"]}"  value="${r"${obj."}${list["itemIndex"]}${r"}"}" disabled="disabled" />
                        <#else>
				          <input type="text" id="${list["key"]}" name="${list["key"]}"  value="${r"${obj."}${id}${r"}"}" disabled="disabled" />
                        </#if>
                        <#break>
                    <#case "date_picker">
				     <input type="text" id="${list["key"]}" name="${list["key"]}" value="${r"${obj."}${id}${r"}"}" disabled="disabled" />
     			     <span class="glyphicon glyphicon-calendar"></span>
                        <#break>

                         <#case "select">
				      <select id="${list["key"]}_select" name="${list["key"]}" style="background-color: #EEEEEE;" disabled="disabled">
                      </select>
					  <span class="glyphicon glyphicon-chevron-down"></span>
                        <#if list["isInitItem"]=='true'>
					    <input type="hidden" id="${list["key"]}"  value="${r"${obj."}${id}${r"}"}"/>
                        </#if>
                        <#break>

                    <#case "textarea">
				     <textarea id="${list["key"]}" value="${r"${obj."}${id}${r"}"}"  disabled="disabled"></textarea>
                        <#break>
                    <#case "table">
				     <table id="${list["key"]}">
                     </table>
                        <#break>
                    <#case "image">
			         <input type="hidden"  id="${list["key"]}_imageKey" name="imageKey_${list["key"]}"  value="${list["key"]}">
			         <a class="file" id="selectFile">选择文件
                         <input type="file" name="zzImage" id="${list["key"]}_image" onchange="uploadZzImg('${list["key"]}_image');" accept="image/jpeg,image/png,image/gif,image/bmp">
                     </a>
			    	 <div class="fix" style="display:none;">
                         <span class="label">&nbsp;</span>
                         <div style="text-align:left;" id="${list["key"]}">
                         </div>
                     </div>
                        <#break>
                    <#case "checkbox">
					   <input type="hidden" id="${list["key"]}"  value="${r"${obj."}${id}${r"}"}"/>
					   <div id="${list["key"]}_div"  style="background-color: #EEEEEE;" disabled="disabled">
                       </div>
                        <#break>
                    <#case "dynamic_table">
			         <table id="${list["key"]}">
                     </table>
                        <#break>
                    <#default>
                </#switch>
              </td>
          </tr>
           </#list>
            <tr>
                <td class="left">附件</td>
                <td>
                    <div class="fix" style="display:none;">
                        <span class="label">&nbsp;</span>
                        <div style="text-align:left;" id="imgFile">
                        </div>
                    </div>
                </td>
            </tr>

        </s:else>

    </table>
</div>



<script type="text/javascript">
    $(function(){
        var now = getFormatDate();
   <#list infoList as list>
       <#if list["typeCode"]=='date_picker'>
        laydate.render({
            elem: '#${list["key"]}',
            min :now,
        });
       </#if>
   </#list>
    });
</script>
