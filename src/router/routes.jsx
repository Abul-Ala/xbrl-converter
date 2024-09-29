const APP_PREFIX = "/app";

const routes = {
  app: {
    login: `${APP_PREFIX}/login`,
    form: `${APP_PREFIX}/form`,
    forgotPwd: `${APP_PREFIX}/forgot-password`,
    changePwd: `${APP_PREFIX}/change-password`,
    home: `${APP_PREFIX}/home`,
  },
};

export default routes;
