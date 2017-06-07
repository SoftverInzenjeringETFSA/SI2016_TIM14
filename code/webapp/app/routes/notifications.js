import Ember from 'ember';

export default Ember.Route.extend({
	ajax: Ember.inject.service(),
	session: Ember.inject.service(),
	inviteUserService: Ember.inject.service('inviteuser-service'),

    model() {
        let id = this.get('session.data.authenticated.korisnik.id');
        let systemMessages = this.get('inviteUserService').findSystemMessages(id);
        if(Ember.isNone(id)){
            this.transitionTo('login');
        }
        console.log(systemMessages);
        return Ember.RSVP.hash({
            mySystemMessages: systemMessages,
        });
    },  
    
});
