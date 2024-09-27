// src/App.js
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import CollegeList from './components/CollegeList';
import CollegeDetail from './components/CollegeDetail';

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<CollegeList />} />
                <Route path="/college/:id" element={<CollegeDetail />} />
            </Routes>
        </Router>
    );
}

export default App;
