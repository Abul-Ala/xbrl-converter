import MainContainer from "@/containers";
import MainRoute from "@/router";
import { BrowserRouter as Router } from "react-router-dom";

const App = () => {
  return (
    <Router>
      <MainContainer>
        <MainRoute />
      </MainContainer>
    </Router>
  );
};

export default App;
