import Ember from 'ember';

export default Ember.Route.extend({
	model: function() {
		
		var usersList = [];
		
		Ember.$.getJSON('http://localhost:8080/api/user', function(users) {
			users.forEach(function(data) {
				usersList.pushObject(data);
			});
		});
		
		return usersList;
	}
});
