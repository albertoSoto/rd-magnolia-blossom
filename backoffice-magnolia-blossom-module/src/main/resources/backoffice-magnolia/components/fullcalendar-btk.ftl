[#include "../../../../backoffice-magnolia/macro/btk-util.ftl"]
[#assign iteration = rand(0,5000)?string["0"]]
<div id="fcalendar${iteration!}" class="fullcalendar-btk">
[#if content.title?has_content]
    <h2>${content.title!}</h2>
[/#if]
    <div id="calendar${iteration!}"></div>
</div>
<script type="text/javascript">
    window.deferAfterjQueryLoaded.push(function () {
    [#assign showNavigation = true]
    [#assign views = '']
    [#if content.calendarOptions?? && content.calendarOptions?seq_index_of("navigation")<0][#assign showNavigation = false][/#if]
    [#if content.calendarOptions?? && content.calendarOptions?seq_index_of("month")!=-1][#assign views = 'month'][/#if]
    [#if content.calendarOptions?? && content.calendarOptions?seq_index_of("week")!=-1][#assign views = views+',basicWeek'][/#if]
    [#if content.calendarOptions?? && content.calendarOptions?seq_index_of("day")!=-1][#assign views = views+',basicDay'][/#if]
        jQuery('#calendar${iteration!}').fullCalendar({
            firstDay: 1,
            header: {
                [#if showNavigation?? && showNavigation!false]left: 'prev,next today', center: 'title',[/#if]
                right: '${views!""}'[#--month,basicWeek,basicDay--]
            },
            events: function events(start, end, timezone, callback) {
                var fOnSuccessCallback = function fOnSuccessCallback(doc) {
                    console.log(doc.events);
                    callback(doc.events);
                };
                jQuery.backofficeApp.global.doAjax('${ctx.contextPath!""}${content.url!}', "GET", null,fOnSuccessCallback, function (e) {
                    console.log("Error loading calendar data");
                });
            },
            timeFormat: 'H(:mm)'
        });
    })
    ;
</script>