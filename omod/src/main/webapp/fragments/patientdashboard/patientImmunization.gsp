
<div class="info-section">

    <div class="info-header">
        <i class="icon-medicine"></i>
        <h3>${ ui.message("nemrapps.patientdashboard.patientImmunization").toUpperCase() }</h3>
        <!--%{--<% if (context.hasPrivilege("ImmunizationAPI: orderentryui.drugOrders")) { %>--}%-->
        <a href="/openmrs/owa/immunizationui/index.html#/vaccines/${ patient.uuid }">
            <i class="icon-share-alt edit-action right" title="${ ui.message("coreapps.edit") }"></i>
        </a>
        <!--%{--<% } %>--}%-->
    </div>

    <div class="info-body">
        <p>More information later</p>
    </div>

</div>