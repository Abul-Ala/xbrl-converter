import { Route, Routes, Navigate } from "react-router-dom";
import routes from "./routes";
import { WithoutAuth } from "./WithoutAuth";
import LoginPage from "@/pages/LoginPage";

const MainRoute = () => {
  return (
    <Routes>
      <Route
        path={routes.app.login}
        element={
          <WithoutAuth path={routes.app.login}>
            <LoginPage />
          </WithoutAuth>
        }
      />
    </Routes>
  );
};

export default MainRoute;
