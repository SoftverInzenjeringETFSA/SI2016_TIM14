import Ember from 'ember';


export default Ember.Controller.extend({
	inviteUserService: Ember.inject.service('inviteuser-service'),
	    session: Ember.inject.service(),
	    self : this,
	     model: function(){
    },

    blockUser2: function(usernameTo)
    {   
    	 var usernameFrom = this.get('session.data.authenticated.korisnik.username')
    	 this.get('inviteUserService').blockUser(usernameFrom, usernameTo);
    	 window.location.reload(true); 
    },
	actions: {
		inviteUser(params) {
			var usernameOfInviter = this.get('session.data.authenticated.korisnik.username');
			var idOfInviter = this.get('session.data.authenticated.korisnik.id');
			this.get('inviteUserService').inviteUser(params, usernameOfInviter, idOfInviter);
		},

		blockUser(usernameTo)
		{
			this.blockUser2(usernameTo);
		},
	}
});
