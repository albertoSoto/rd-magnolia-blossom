[#include "../macro/btk-util.ftl"]
[#include "../macro/btk-table-helper.ftl"]
[#assign iteration = rand(0,5000)?string["0"]]
[#assign datatableID = "datatable"+iteration]
<div class="datatable-btk">
[#if content.title?has_content]
    <h2>${content.title!}</h2>
[/#if]
[@datatable object="" configuration=content id=datatableID!""/]
</div>
<script type="text/javascript">
    window.deferAfterjQueryLoaded.push(function () {
        var btk_${datatableID!} = jQuery('#${datatableID}').DataTable(
        [#assign ajaxUrl = content.url!""]
                {
                    "columnDefs": [
                    [#assign colcounter = 0]
                    [#if customColumns??]
                        [#list customColumns as column]
                            [#if customLabels??]
                                [#assign customColumnName=customLabels[column_index]!""]
                            [/#if]
                            {
                                "targets": ${colcounter!"0"},
                                "data": "${column!""}",
                                "title": "${customColumnName!column!""}"
                            }[#if column_has_next],[/#if]
                            [#assign colcounter = colcounter+1]
                        [/#list]
                    [/#if]],
                    "ajax": "[#if content.enableCtx?? && content.enableCtx]${ctx.contextPath!""}[/#if]${ajaxUrl!""}"
                }
        );
    });
</script>