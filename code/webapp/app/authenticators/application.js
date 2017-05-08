import Ember from 'ember';
import Base from 'ember-simple-auth/authenticators/base';
import ENV from '../config/environment';

const {RSVP: { Promise }} = Ember;

export default Base.extend({
    authRoute: `${ENV.APP.api}/auth/login`,
    libHttp: Ember.inject.service('lib-http'),

    restore(data) {
        return new Promise((resolve, reject) => {
            if (!Ember.isEmpty(data.token)) {
                resolve(data);
            } else {
                reject();
            }
        });
    },

    authenticate(credentials) {
        return this.get('libHttp').post('auth/login', credentials, (resp) => {
          return { 
            user: resp 
          }});
    },

    invalidate(data) {
        return Promise.resolve(data);
    }
});