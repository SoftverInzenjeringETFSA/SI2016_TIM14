import Ember from 'ember';

export default Ember.Component.extend({
    store: Ember.inject.service(),
    session: Ember.inject.service(),
    
    actions: {
        tempLogin: function() {
            this.get('session').authenticate('authenticator:application', { username: 'mirza', password: 'mirzapw'}).catch((reason)=>{
				this.set('authenticationError', reason.error || reason);
			});
        }
    }
});
