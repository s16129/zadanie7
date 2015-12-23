
function PersonViewModel(model){
	var listOfPeople='listOfPeople';
	ko.mapping.fromJS(model,{},this);
	var self = this;

	self.show = function(){
		alert(ko.mapping.toJSON(self));
	}
	
	self.add = function(){
		if(!sessionStorage.getItem(listOfPeople)){
			sessionStorage.setItem(listOfPeople, JSON.stringify([ko.mapping.toJS(self)]));
		}else{
			var list = JSON.parse(sessionStorage.getItem(listOfPeople));
			list.push(ko.mapping.toJS(self));
			sessionStorage.setItem(listOfPeople,JSON.stringify(list));
		}
	}
}