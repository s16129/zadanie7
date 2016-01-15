
function PersonViewModel(model){
	var listOfPeople='listOfPeople';
	ko.mapping.fromJS(model,{},this);
	var self = this;

	self.show = function(){
		alert(ko.mapping.toJSON(self));
	}
	
	self.add = function(){
		$.ajax({
            url: "http://localhost:8080/servletjspdemo/rest/people/add",
            type: "PUT",
            data: ko.mapping.toJSON(self),
            contentType: "application/json",
            success: function (data) {
                alert("udało się");
            },
            error: function (XMLHttpRequest, testStatus, errorThrown) {
               alert("nie udało się")

            }
        });
	}
}