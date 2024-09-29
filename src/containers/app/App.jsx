//import MainContainer from "@/containers";
import MainContainer from "@/components/MainContainer";
import MainRoute from "@/router";
import { BrowserRouter as Router } from "react-router-dom";
import { PersistGate } from "redux-persist/integration/react";
import { store, persistor } from "@/providers/store";
import { Provider } from "react-redux";


const App = () => {
  return (

    <Provider store={store}>
    <PersistGate persistor={persistor}>
    <Router>
      <MainContainer>
        <MainRoute />
      </MainContainer>
    </Router>
    </PersistGate>
    </Provider>
   
  );
};


export default App;
