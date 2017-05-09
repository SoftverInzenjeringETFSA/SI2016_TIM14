import Ember from 'ember';

export default Ember.Controller.extend({
    isToSAccepted: Ember.computed.not('isToSCheckboxChecked'),
    model: {},
    actions: {
        register() {
            let _userSvc = this.get('userSvc');

            _userSvc.register(this.model, (resp) => alert("success"));
        }
    }
});