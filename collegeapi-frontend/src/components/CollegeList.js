// src/components/CollegeList.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

const CollegeList = () => {
    const [colleges, setColleges] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchColleges = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/colleges');
                if (Array.isArray(response.data)) {
                    setColleges(response.data);
                } else {
                    setError('Unexpected data format');
                }
            } catch (err) {
                setError('Failed to fetch colleges');
            }
        };

        fetchColleges();
    }, []);

    return (
        <div>
            <h1>List of Colleges</h1>
            {error && <p style={{ color: 'red' }}>{error}</p>}
            <ul>
                {colleges.map(college => (
                    <li key={college.id}>
                        <Link to={`/college/${college.id}`}>{college.name}</Link>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default CollegeList;
