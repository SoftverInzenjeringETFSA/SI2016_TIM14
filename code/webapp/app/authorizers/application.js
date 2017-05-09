import Ember from 'ember';
import Base from 'ember-simple-auth/authenticators/base';

export default Base.extend({  
	session: Ember.inject.service(),
	authorize(data, block) {
		if (this.get('session.isAuthenticated') && data) {
			block('Authorization', `Bearer ${data}`);
		}
	}
});