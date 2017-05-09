export function initialize(application) {
  application.inject('route', 'userSvc', 'service:userSvc');
  application.inject('controller', 'userSvc', 'service:userSvc');
  application.inject('component', 'userSvc', 'service:userSvc');
}

export default {
  name: 'userSvc',
  initialize
};
