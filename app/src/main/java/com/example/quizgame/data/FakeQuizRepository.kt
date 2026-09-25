package com.example.quizgame.data

import com.example.quizgame.domain.Quiz
import com.example.quizgame.domain.QuizRepository
import com.google.gson.Gson
import kotlinx.coroutines.delay


class FakeQuizRepository (
    private val gson: Gson
): QuizRepository {

    override suspend fun getQuiz(): Quiz {
        delay(3000)
        val jsonString = "{\n" +
                "  \"questions\": [\n" +
                "    {\n" +
                "      \"questionId\": 1,\n" +
                "      \"question\": \"What is the capital of France?\",\n" +
                "      \"options\": [\n" +
                "        {\n" +
                "          \"optionId\": 1,\n" +
                "          \"option\": \"Berlin\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 2,\n" +
                "          \"option\": \"Madrid\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 3,\n" +
                "          \"option\": \"Paris\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 4,\n" +
                "          \"option\": \"Rome\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"answerId\": 3\n" +
                "    },\n" +
                "    {\n" +
                "      \"questionId\": 2,\n" +
                "      \"question\": \"Which planet is known as the Red Planet?\",\n" +
                "      \"options\": [\n" +
                "        {\n" +
                "          \"optionId\": 5,\n" +
                "          \"option\": \"Earth\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 6,\n" +
                "          \"option\": \"Mars\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 7,\n" +
                "          \"option\": \"Jupiter\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 8,\n" +
                "          \"option\": \"Venus\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"answerId\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"questionId\": 3,\n" +
                "      \"question\": \"What is the largest ocean on Earth?\",\n" +
                "      \"options\": [\n" +
                "        {\n" +
                "          \"optionId\": 9,\n" +
                "          \"option\": \"Atlantic Ocean\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 10,\n" +
                "          \"option\": \"Indian Ocean\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 11,\n" +
                "          \"option\": \"Arctic Ocean\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 12,\n" +
                "          \"option\": \"Pacific Ocean\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"answerId\": 12\n" +
                "    },\n" +
                "    {\n" +
                "      \"questionId\": 4,\n" +
                "      \"question\": \"Who wrote the play Romeo and Juliet?\",\n" +
                "      \"options\": [\n" +
                "        {\n" +
                "          \"optionId\": 13,\n" +
                "          \"option\": \"William Shakespeare\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 14,\n" +
                "          \"option\": \"Charles Dickens\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 15,\n" +
                "          \"option\": \"Mark Twain\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 16,\n" +
                "          \"option\": \"Jane Austen\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"answerId\": 13\n" +
                "    },\n" +
                "    {\n" +
                "      \"questionId\": 5,\n" +
                "      \"question\": \"What is the chemical symbol for gold?\",\n" +
                "      \"options\": [\n" +
                "        {\n" +
                "          \"optionId\": 17,\n" +
                "          \"option\": \"Ag\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 18,\n" +
                "          \"option\": \"Au\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 19,\n" +
                "          \"option\": \"Fe\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 20,\n" +
                "          \"option\": \"Cu\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"answerId\": 18\n" +
                "    },\n" +
                "    {\n" +
                "      \"questionId\": 6,\n" +
                "      \"question\": \"Which programming language is primarily used for Android development?\",\n" +
                "      \"options\": [\n" +
                "        {\n" +
                "          \"optionId\": 21,\n" +
                "          \"option\": \"Kotlin\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 22,\n" +
                "          \"option\": \"Swift\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 23,\n" +
                "          \"option\": \"Ruby\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 24,\n" +
                "          \"option\": \"PHP\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"answerId\": 21\n" +
                "    },\n" +
                "    {\n" +
                "      \"questionId\": 7,\n" +
                "      \"question\": \"How many continents are there on Earth?\",\n" +
                "      \"options\": [\n" +
                "        {\n" +
                "          \"optionId\": 25,\n" +
                "          \"option\": \"Five\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 26,\n" +
                "          \"option\": \"Six\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 27,\n" +
                "          \"option\": \"Seven\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 28,\n" +
                "          \"option\": \"Eight\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"answerId\": 27\n" +
                "    },\n" +
                "    {\n" +
                "      \"questionId\": 8,\n" +
                "      \"question\": \"Which data structure follows the LIFO principle?\",\n" +
                "      \"options\": [\n" +
                "        {\n" +
                "          \"optionId\": 29,\n" +
                "          \"option\": \"Queue\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 30,\n" +
                "          \"option\": \"Stack\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 31,\n" +
                "          \"option\": \"Array\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 32,\n" +
                "          \"option\": \"Linked List\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"answerId\": 30\n" +
                "    },\n" +
                "    {\n" +
                "      \"questionId\": 9,\n" +
                "      \"question\": \"What is the largest mammal in the world?\",\n" +
                "      \"options\": [\n" +
                "        {\n" +
                "          \"optionId\": 33,\n" +
                "          \"option\": \"African Elephant\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 34,\n" +
                "          \"option\": \"Blue Whale\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 35,\n" +
                "          \"option\": \"Giraffe\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 36,\n" +
                "          \"option\": \"Hippopotamus\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"answerId\": 34\n" +
                "    },\n" +
                "    {\n" +
                "      \"questionId\": 10,\n" +
                "      \"question\": \"Which Jetpack Compose annotation indicates that a class is immutable?\",\n" +
                "      \"options\": [\n" +
                "        {\n" +
                "          \"optionId\": 37,\n" +
                "          \"option\": \"@Composable\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 38,\n" +
                "          \"option\": \"@Stable\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 39,\n" +
                "          \"option\": \"@Immutable\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"optionId\": 40,\n" +
                "          \"option\": \"@Preview\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"answerId\": 39\n" +
                "    }\n" +
                "  ]\n" +
                "}"

        return runCatching { gson.fromJson(jsonString, Quiz::class.java) }.getOrNull() ?: Quiz.empty
    }
}