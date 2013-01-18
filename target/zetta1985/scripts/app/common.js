define(["app/common/constant"]
,function(constant) {

	var common = {};
	
	common.getRealPath = function(val){
		return constant.context + "/" + val;
	};
	
	common.getServicePath = function(val){
		return constant.context + "/service/" + val;
	};
	
	return common;
});