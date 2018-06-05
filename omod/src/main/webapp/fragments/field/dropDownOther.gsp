<%
    config.require("formFieldName")
    config.require("options")

    def required = config.classes && config.classes.contains("required");

    def selectDataBind = "";
    if (config.depends && config.depends.disable) {
        selectDataBind += "disable: ${ config.depends.variable }() == '${ config.depends.disable }'"
    }
    if (config.depends && config.depends.enable) {
        selectDataBind += "enable: ${ config.depends.variable }() == '${ config.depends.enable }'"
    }
    if (config.dependency || required) {
        selectDataBind += ", value: ${ config.id }"
    }

    def cleanup = {
        return (it instanceof org.codehaus.jackson.node.TextNode) ? it.textValue : it;
    }

    def otherAttributes = ''
    if (config.otherAttributes){
        config.otherAttributes.each{ attr, val ->
            otherAttributes += (' ' + attr + '="' + val + '"')
        }
    }
%>

<p id="${ config.id }"
    <% if (config.depends) { %> data-bind="visible: ${ config.depends.variable }() == '${ config.depends.value }'" <% } %>
    <% if (config.left) { %> class="left" <% } %>  >

    <label for="${ config.id }-field">
        ${ ui.message(config.label) ?: '' } <% if (required) { %><span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span><% } %>
    </label>

    <select id="${ config.id }-field" name="${ config.formFieldName }"
            <% if (config.classes) { %> class="${ config.classes.join(' ') }" <% } %>
            <% if (config.expanded || config.maximumSize) { %> size="${ [config?.maximumSize, config.options.size() + (config.hideEmptyLabel ? 0 : 1)].min() }" <% } %>
            <% if (selectDataBind) { %> data-bind="${ selectDataBind }" <% } %> ${otherAttributes}>

        <% if(!config.hideEmptyLabel) { %>
            <option value="">${ ui.message(config.emptyOptionLabel ?: '&nbsp;') }</option>
        <% } %>
        <% config.options.each {
            def selected = it.selected || it.value == config.initialValue || cleanup(it.value) == config.initialValue
        %>
            <option value="${ cleanup(it.value) }"  <% if (selected) { %>selected<% } %>>${ ui.message(cleanup(it.label)) }</option>
        <% } %>
        <% if(config.other) { %>
            <option value="value-for-other-select-label"  <% if (config.other.selected) { %>selected<% } %>>${ ui.message(cleanup(config.other.label)) }</option>
        <% } %>
    </select>
    <br/>
    <% if(config.other) { %>
        <p id="p-${ config.id }-field-other" style="display: none;">
            <label for="${ config.id }-field-other">
                ${ ui.message(config.other.inputLabel) ?: '' } <% if (required) { %><span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span><% } %>
            </label>
            <input id="${ config.id }-field-other" type="text" <% if (config?.other.classes) { %> class="${ config.other.classes.join(' ') }" <% } %> />
        </p>
    <% } %>
    ${ ui.includeFragment("uicommons", "fieldErrors", [ fieldName: config.formFieldName ]) }
</p>

<% if (config.dependency || required) { %>
<script type="text/javascript">
    var viewModel = viewModel || {};
    viewModel.validations = viewModel.validations || [];

    viewModel.${ config.id } = ko.observable();
    <% if (required) { %>
    viewModel.validations.push(function() {
        return jq('#${ config.id }-field').is(':disabled') || (viewModel.${ config.id }() ? true : false);
    });
    <% } else { %>
    viewModel.validations.push(function() {
        viewModel.${ config.id }();
        return true;
    });
    <% } %>
</script>
<% } %>
<!-- Handle the other ethnicity type not listed in the drop down list. -->
<script type="text/javascript">
    <% if(config?.other) { %>
    jq('#${ config.id }-field').change(function() {
        console.log(jq('#${ config.id }-field').val());
        if(jq('#${ config.id }-field').val() === "value-for-other-select-label") {
            jq('#${ config.id }-field').removeAttr('name');
            jq('#${ config.id }-field-other').attr('name', '${ config.formFieldName }');
            jq('#p-${ config.id }-field-other').show();
        }
        else {
            jq('#${ config.id }-field').attr('name', '${ config.formFieldName }');
            jq('#${ config.id }-field-other').removeAttr('name');
            jq('#p-${ config.id }-field-other').hide();
        }
    });
    <% } %>
</script>
