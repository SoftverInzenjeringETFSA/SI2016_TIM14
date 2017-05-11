import Ember from 'ember';


export default Ember.Controller.extend({
	actions: {
		register: function()
	{
		var username= this.get('model.username');
	}
	}
});
