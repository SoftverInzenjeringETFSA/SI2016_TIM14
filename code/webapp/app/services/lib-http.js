import Ember from 'ember';
import ENV from '../config/environment';

const { RSVP: { Promise }, $: { ajax }, run } = Ember;

export default Ember.Service.extend({
    _innerCreateMethod(route, data, httpRequest, onSuccess, onFailure) {
        let requestOptions = {
            url: `${ENV.APP.api}/${route}`,
            contentType: 'application/json; charset=utf-8',
            type: httpRequest,
            dataType: 'json'
        };

        if (data) {
            requestOptions.data = JSON.stringify(data);
        }

        return new Promise((resolve, reject) => {
            ajax(requestOptions).then((response) => {
                run(() => {
                    if (onSuccess) {
                        resolve(onSuccess(response));
                    }
                    else {
                        resolve();
                    }
                });
                }, (error) => {
                    run(() => {
                        if (onFailure) {
                            onFailure(error);
                        }

                        reject(error);
                    });
            });
        });
    },

    get(route, data, onSuccess, onFailure) {
        return this._innerCreateMethod(route, null, 'GET', onSuccess, onFailure);
    },
    
    post(route, data, onSuccess, onFailure) {
        return this._innerCreateMethod(route, data, 'POST', onSuccess, onFailure);
    }
});
