import Ember from 'ember';

export default Ember.Service.extend({
    libHttp: Ember.inject.service('lib-http'),
    
    register(user, happyPath, errorPath) {
        return this.get('libHttp').post('auth/register', user, (resp) => {
            if (happyPath) {
                happyPath(true);
            }
        }, (resp) => {
            if (errorPath) {
                errorPath(false)
            }
        });
    }
});
