function PersonListViewModel(list){
	var self = this;
	self.people = ko.observableArray([]);
	
	for(var i=0; i<list.length;i=i+1){
		self.people().push(new PersonViewModel(list[i]))
	}
}