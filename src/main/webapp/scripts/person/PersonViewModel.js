function PersonViewModel(model){
	var listOfpeople = 'listOfPeople';
	ko.mapping.fromJS(model,{},this);
	var self = this;
	self.showAlert = function(){
		alert(ko.mapping.toJSON(self));
	};
	
	self.add = function(){
		if(!sessionStorage.getItem(listOfpeople)){
			sessionStorage.setItem(listOfpeople, JSON.stringify([ko.mapping.toJS(self)]));
		}else{
			var list = JSON.parse(sessionStorage.getItem(listOfpeople));
			list.push(ko.mapping.toJS(self));
			sessionStorage.setItem(listOfpeople, JSON.stringify(list));
		}
	}
}