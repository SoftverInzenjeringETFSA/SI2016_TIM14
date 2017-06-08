import Ember from 'ember';
import User from '../models/user';
import BlockedUser from '../models/blocked-user';

export default Ember.Route.extend({
	ajax: Ember.inject.service(),
	session: Ember.inject.service(),
	inviteUserService: Ember.inject.service('inviteuser-service'),
    model: function(params, transition) {
    	let id = this.get('session.data.authenticated.korisnik.id');
    	if(Ember.isNone(id)){
            this.transitionTo('login');
        } 
        let un = this.get('session.data.authenticated.korisnik.username');
        let users = this.get('inviteUserService').allExceptMe(id);
        let blocked_users = this.get('inviteUserService').blockedUsers(un);

        return Ember.RSVP.hash({
            usersToInvite: users,
            blockedUsers: blocked_users,
        });
    }

    
});
