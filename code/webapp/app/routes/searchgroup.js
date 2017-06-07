import Ember from 'ember';

export default Ember.Route.extend({
session: Ember.inject.service(),
  groupService: Ember.inject.service(),
	model: function(params, transition) {
		let id = this.get('session.data.authenticated.korisnik.id');
        if(Ember.isNone(id)){
            this.transitionTo('login');
        } 
	    let groups = this.get('groupService').searchGroups(params.searchgroupTerm);
	    return Ember.RSVP.hash({
	        searchedGroups: groups
	    });
	}
	
});
