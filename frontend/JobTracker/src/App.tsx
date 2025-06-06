import { Outlet, RouterProvider } from "react-router-dom";
import { router } from "./utils/routes/routes";

function App() {
  return (
    <div>
      <RouterProvider router={router} />
      <Outlet />
    </div>
  );
}

export default App;
