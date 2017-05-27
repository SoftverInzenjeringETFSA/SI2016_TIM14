import Ember from 'ember';


export default Ember.Controller.extend({
	inviteUserService: Ember.inject.service('inviteuser-service'),
	session:  Ember.inject.service()
});