import Ember from 'ember';

export default Ember.Component.extend({
    store: Ember.inject.service(),
    session: Ember.inject.service(),

    model: {
        username: null,
        password: null,
    },

    actions: {
        login: function() {
            this.get('session').authenticate('authenticator:application', this.model)
                .then(() => {
                    // happy path - login was successful
                    this.get('onLogin')();
                })
                .catch((reason)=>{
				this.set('authenticationError', reason.error || reason);
			});
        }
    }
});
