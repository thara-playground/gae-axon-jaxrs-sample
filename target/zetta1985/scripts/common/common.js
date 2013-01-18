define(["constant"]
,function(constant) {

	var util = {};
	
	util.getRealPath = function(val){
		return constant.context + "/" + val;
	};
	
	util.getServicePath = function(val){
		return constant.context + "/service/" + val;
	};
	
	return util;
});