[#include "../../../../backoffice-magnolia/macro/btk-util.ftl"]
[#assign iteration = rand(0,5000)?string["0"]]
<div class="highchart-btk" id="hchart${iteration!}">
[#if content.title?has_content]
    <h2>${content.title!}</h2>
[/#if]
</div>
<script type="text/javascript">
    window.deferAfterjQueryLoaded.push(function () {
        var currentSeries = [];
        jQuery.backofficeApp.global.doAjax('/author/api/rest/v1/stats/salary.json', 'GET', null, function (result) {
            if (result.series) {
                result.series.forEach(function f(item, index) {
                    currentSeries.push(item);
                });
            }
            Highcharts.chart('hchart${iteration!}', {
                title: {
                    text: '${content.title!""}'
                },
                subtitle: {
                    text: '${content.subtitle!""}'
                },
                yAxis: {
                    title: {
                        text: '${content.yaxisLabel!""}'
                    }
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle'
                },
                series: currentSeries
            });
        }, function (e) {
            console.log("error al cargar escenas")
        });
    });
</script>
