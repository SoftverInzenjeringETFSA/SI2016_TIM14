import Ember from 'ember';

export default Ember.Route.extend({
	ajax: Ember.inject.service(),
	session: Ember.inject.service(),
	inviteUserService: Ember.inject.service('inviteuser-service'),
    model() {
    	let id = this.get('session.data.authenticated.korisnik.id');
    	if(Ember.isNone(id)){
            this.transitionTo('login');
        } 
        let users = this.get('inviteUserService').allExceptMe(id);
        return Ember.RSVP.hash({
            usersToInvite: users,
        });
    }
    
});
