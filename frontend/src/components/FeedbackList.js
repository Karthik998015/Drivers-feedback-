import React, { useState, useEffect } from 'react';
import axios from 'axios';

const FeedbackList = () => {
    const [feedbacks, setFeedbacks] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchFeedbacks = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/feedback');
                setFeedbacks(response.data);
                setLoading(false);
            } catch (err) {
                setError('Error fetching feedbacks');
                setLoading(false);
            }
        };

        fetchFeedbacks();
    }, []);

    if (loading) return <div className="text-center">Loading...</div>;
    if (error) return <div className="text-center text-red-500">{error}</div>;

    return (
        <div className="max-w-4xl mx-auto p-6">
            <h2 className="text-2xl font-bold mb-4">Driver Feedbacks</h2>
            <div className="space-y-4">
                {feedbacks.map(feedback => (
                    <div key={feedback.id} className="bg-white p-4 rounded-lg shadow-md">
                        <div className="flex justify-between items-start">
                            <div>
                                <h3 className="text-lg font-semibold">{feedback.driverName}</h3>
                                <p className="text-sm text-gray-600">By: {feedback.passengerName}</p>
                            </div>
                            <div className="flex items-center">
                                <span className="text-yellow-500">
                                    {'★'.repeat(feedback.rating)}
                                    {'☆'.repeat(5 - feedback.rating)}
                                </span>
                            </div>
                        </div>
                        {feedback.comment && (
                            <p className="mt-2 text-gray-700">{feedback.comment}</p>
                        )}
                        <p className="mt-2 text-sm text-gray-500">
                            {new Date(feedback.feedbackDate).toLocaleString()}
                        </p>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default FeedbackList; 