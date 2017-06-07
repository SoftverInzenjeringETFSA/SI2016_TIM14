import Ember from 'ember';

export default Ember.Route.extend({
	userService: Ember.inject.service(),
	session: Ember.inject.service(),
	model: function(params, transition) {
		
		/*let users = this.get('userService').all();
	    return Ember.RSVP.hash({
	        searchedUsers: users
	    });*/
	    let id = this.get('session.data.authenticated.korisnik.id');
        if(Ember.isNone(id)){
            this.transitionTo('login');
        } 
	    let users = this.get('userService').searchUsers(params.searchuserTerm);
	    return Ember.RSVP.hash({
	        searchedUsers: users
	    });
	}
	
});