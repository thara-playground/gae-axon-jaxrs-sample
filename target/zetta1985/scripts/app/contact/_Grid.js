define([
  "debug",
  "app/common/inherit",
],function(debug, inherit, api) {

	var ContactGrid = inherit(
		Object,
		function(){
			this.name = "ContactGrid";
			
			var names = colNames();
			var models = colModel();
			
			var $grid = $("#contactGrid");
			$grid.jqGrid({
				//url : "",
				//dataType : "",
				//mtype: "POST", 
				colNames : names,
				colModel : models,
				rowNum : 10,
				rowList:[10,20,30],
				pager: '#contactGridPager',
				sortname: models[0].name,
				viewrecords: true,
				sortorder: "desc"
			});
			
			$grid.jqGrid('navGrid','#pparams',{edit:false,add:false,del:false}); 
		},
		{
		}
	);
	
	function colNames() {
		return ['Name'];
	}
	
	function colModel() {
		return [{name:'name',index:'name', width:55}];
	}
	
	return ContactGrid;
});