// src/components/CollegeDetail.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

const CollegeDetail = () => {
    const { id } = useParams();
    const [college, setCollege] = useState(null);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchCollege = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/colleges/${id}`);
                setCollege(response.data);
            } catch (err) {
                setError('Failed to fetch college details');
            }
        };

        fetchCollege();
    }, [id]);

    if (error) return <p style={{ color: 'red' }}>{error}</p>;
    if (!college) return <p>Loading...</p>;

    return (
        <div>
            <h1>{college.name}</h1>
            <h2>Courses</h2>
            <ul>
                {college.courses.map(course => (
                    <li key={course.id}>
                        <p><strong>Course Name:</strong> {course.name}</p>
                        <p><strong>Duration:</strong> {course.duration} years</p>
                        <p><strong>Accommodation Type:</strong> {course.accommodationType}</p>
                        <p><strong>Accommodation Fee:</strong> ${course.accommodationFee}</p>
                        <p><strong>Course Fee:</strong> ${course.courseFee.fee}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default CollegeDetail;
