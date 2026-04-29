import './App.css'
import Footer from './components/Footer.jsx';
import Menubar from "./components/Menubar.jsx";
import Home from './pages/Home.jsx';
import { BrowserRouter, Routes, Route } from "react-router";
import { Toaster } from "react-hot-toast";

function App() {
    return (
      <div>
        <Menubar/>
        <Toaster/>
        <Routes>
          <Route path='/' element={<Home/>}/>
        </Routes>
        <Footer/>
      </div>
    );
}
export default App
