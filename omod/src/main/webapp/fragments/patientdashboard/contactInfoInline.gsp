<%
    config.contextModel.put("returnUrl", ui.thisUrl())
%>

<div class="contact-info-inline">
    <span>
        <span id="coreapps-telephoneNumber">
            ${ ui.encodeHtmlContent(config.patient.telephoneNumber ?: '') }
        </span>
        <em>${ ui.message("coreapps.person.telephoneNumber")}</em>
    </span>
    <span class="left-margin">
        <span id="nemrapps-alt-phone-numbers">
            ${ ui.encodeHtmlContent(config.altPhoneNumbers) }
        </span>
        <em>${ ui.message("nemrapps.patient.otherPhoneNumbers")}</em>
    </span>
    <br/>
    <span>
        <span id="nemrapps-neighbor-name">
            ${ ui.encodeHtmlContent(config.neighborName) }
        </span>
        <em>${ ui.message("nemrapps.patient.personAttribute.closeRelativeName")}</em>
    </span>
    <span class="left-margin">
        <span id="nemrapps-neighbor-phone-numbers">
            ${ ui.encodeHtmlContent(config.neighborPhoneNumbers) }
        </span>
        <em>${ ui.message("nemrapps.person.neighborPhoneNumbers")}</em>
    </span>
    <br/>
    <span>
        ${ ui.encodeHtmlContent(ui.format(config.patient.personAddress).replace("\n", ", "))}
        <em>${ ui.message("coreapps.person.address")}</em>
    </span>
    <% if(!config.hideEditDemographicsButton) { %>
    <small id="contact-info-inline-edit" class="edit-info" class="left-margin">
        <%= ui.includeFragment("appui", "extensionPoint", [ id: "nigeria.patient.editContactInfo",
                                                            contextModel: config.contextModel, patientId: config.patientId ]) %>
    </small>
    <% } %>
</div>
