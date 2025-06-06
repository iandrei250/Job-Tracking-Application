import { Outlet } from "react-router-dom";
import { Navbar } from "./components/shared/Navbar";

function App() {
  return (
    <div className="size-svh">
      <Navbar />
      <Outlet />
    </div>
  );
}

export default App;
