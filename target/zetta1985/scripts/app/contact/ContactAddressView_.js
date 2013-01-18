define([
  "debug",
  "common/inherit",
  "common/util",
  "app/contact/api/ContactAddressApi",
  "text!app/contact/tmpl/addressForm.html",
  "text!app/contact/tmpl/addressEntry.html"
],function(debug, inherit, util, api, formHTML, entryHTML) {

	var ContactAddressView = inherit(
		Object,
		function(){
			this.name = "ContactAddressView";
			debug.assert(typeof this.contactView != "undefined");
			debug.assert(typeof this.$wrapper != "undefined");
			
			var self = this;
			
			var contactView = this.contactView;
			
			$.tmpl(formHTML, {}).appendTo($("#addressForm", this.$wrapper));
			
			var $form = $("form[name='addressForm']");
			
			$("input[name='createAddress']").live("click", function(){
				var id = contactView.selectedId();
				api.createAddress({
					contactId : id,
					data : util.form2Hash($form),
					callback : function(){
						self.loadList();
					}
				});
			});
		},
		{
			loadList : function(param) {
				var contactId = param ? param.contactId : this.contactId; 
				debug.assert(typeof contactId != "undefined");
				
				var self = this;
				$("#address_Entries tbody").empty();
				api.loadAddresses({
					contactId : contactId,
					callback : function(data){
						self.contactId = contactId;
						$.tmpl(entryHTML, data).appendTo("#address_Entries tbody");
					}
				});
			}
		}
	);
	
	return ContactAddressView;
});