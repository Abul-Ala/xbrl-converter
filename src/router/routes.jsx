const APP_PREFIX = "/app";

const routes = {
  app: {
    login: `${APP_PREFIX}/login`,
    forgotPwd: `${APP_PREFIX}/forgot-password`,
    changePwd: `${APP_PREFIX}/change-password`,
    home: `${APP_PREFIX}/home`,
  },
};

export default routes;
