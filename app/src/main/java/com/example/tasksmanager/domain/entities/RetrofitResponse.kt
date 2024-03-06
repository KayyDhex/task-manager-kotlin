package com.example.tasksmanager.domain.entities

data class ResponseGemini(
    val candidates: List<Candidate>,
    val promptFeedback: PromptFeedback,
)

data class Candidate(
    val content: Content,
    val finishReason: String,
    val index: Long,
    val safetyRatings: List<SafetyRating>,
)

data class Content(
    val parts: List<Part>,
    val role: String?,
)

data class Part(
    val text: String,
)

data class SafetyRating(
    val category: String,
    val probability: String,
)

data class PromptFeedback(
    val safetyRatings: List<SafetyRating2>,
)

data class SafetyRating2(
    val category: String,
    val probability: String,
)
