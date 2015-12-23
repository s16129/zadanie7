function PersonListViewModel(listOfPersons){
	
	var self=this;
	self.people=ko.observableArray([]);
	
	for(var i=0; i<listOfPersons.length;i=i+1){
		self.people().push(new PersonViewModel(listOfPersons[i]))
	}
	
}