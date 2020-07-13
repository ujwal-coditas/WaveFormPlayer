package fr.haran.example

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.haran.soundwave.controller.DefaultPlayerController
import fr.haran.soundwave.ui.PlayerView
import java.io.IOException

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private var amplitudes = arrayOf(-0.009, 0.005, 0.004, 0.0, 0.001, -0.004, 0.002, -0.004, -0.002, -0.002, 0.006, 0.008, 0.019, -0.039, 0.121, 0.126, 0.046, -0.026, -0.027, -0.095, -0.0, -0.017, 0.006, -0.067, 0.026, -0.08, 0.009, 0.018, -0.018, -0.005, -0.002, -0.003, 0.005, 0.011, 0.002, -0.004, 0.003, 0.01, 0.011, -0.011, -0.003, 0.002, -0.001, -0.008, 0.001, 0.001, -0.011, -0.009, 0.004, 0.012, -0.05, 0.235, 0.152, -0.073, -0.152, -0.006, 0.091, 0.001, -0.068, -0.063, -0.021, -0.018, 0.05, 0.001, -0.018, 0.048, 0.001, -0.029, -0.004, 0.009, -0.014, 0.006, -0.001, 0.001, 0.001, -0.798, -0.37, 0.749, -0.496, -0.14, -0.036, -0.014, 0.014, 0.038, -0.014, -0.026, -0.004, -0.01, 0.003, -0.011, -0.001, -0.01, -0.015, 0.001, -0.002, -0.002, 0.015, -0.019, -0.019, 0.028, 0.014, 0.003, -0.054, -0.047, -0.013, 0.005, 0.007, -0.005, 0.006, -0.03, 0.147, 0.056, -0.051, 0.067, 0.048, 0.347, 0.039, -0.319, 0.386, 0.339, 0.036, 0.152, -0.016, -0.013, 0.016, -0.011, -0.0, -0.002, 0.006, 0.0, -0.002, -0.011, -0.008, -0.009, -0.001, -0.004, 0.016, 0.013, 0.004, 0.004, 0.004, 0.002, -0.002, 0.004, 0.001, 0.008, 0.001, -0.007, -0.001, -0.001, -0.009, -0.003, 0.011, 0.028, 0.074, 0.042, -0.006, 0.023, 0.051, -0.003, 0.001, 0.167, 0.235, -0.191, -0.016, -0.043, 0.434, -0.266, 0.045, -0.128, -0.08, 0.068, -0.075, 0.042, 0.076, 0.068, 0.012, -0.009, 0.006, 0.025, 0.021, 0.024, 0.023, -0.005, -0.017, 0.003, -0.01, 0.001, -0.022, -0.006, 0.032, 0.009, 0.016, -0.002, -0.017, 0.001, 0.006, -0.002, 0.587, -0.614, -0.108, -0.274, -0.06, -0.01, -0.005, -0.01, 0.01, -0.001, -0.003, -0.007, 0.008, 0.009, -0.005, 0.004, 0.014, -0.003, 0.004, -0.007, 0.007, 0.01, 0.002, -0.007, 0.019, -0.001, -0.008, 0.002, -0.021, 0.006, -0.051, 0.033, -0.016, 0.025, -0.029, -0.024, 0.021, -0.014, -0.002, -0.001, -0.016, 0.022, 0.011, -0.002, 0.011, -0.001, -0.01, 0.008, -0.001, 0.005, 0.001, -0.009, 0.006, -0.007, 0.037, -0.133, -0.021, 0.024, -0.009, -0.035, -0.049, 0.041, 0.012, -0.016, 0.041, -0.014, 0.038, -0.055, -0.012, 0.028, 0.022, -0.011, 0.0, 0.004, 0.003, -0.006, 0.006, -0.002, 0.001, -0.007, -0.004, -0.008, 0.005, -0.004, -0.004, -0.011, 0.009, 0.0, 0.004, -0.01, 0.007, -0.021, 0.115, -0.198, 0.044, 0.028, -0.006, -0.068, -0.036, -0.005, 0.014, -0.015, 0.016, 0.006, -0.043, -0.009, 0.0, -0.017, -0.008, -0.011, -0.005, -0.002, -0.011, 0.011, -0.012, 0.008, 0.0, 0.674, 0.06, -0.032, -0.353, 0.186, -0.021, 0.08, -0.028, -0.021, 0.081, -0.027, -0.006, -0.009, 0.004, -0.002, 0.003, 0.008, 0.007, 0.006, -0.01, -0.016, 0.017, 0.001, 0.004, 0.036, 0.031, -0.028, -0.079, 0.031, -0.017, -0.014, 0.007, 0.001, 0.009, 0.014, 0.066, 0.008, -0.025, -0.021, -0.066, -0.245, 0.419, 0.41, -0.157, -0.103, 0.128, 0.139, -0.058, 0.029, -0.015, 0.003, 0.001, -0.006, 0.005, -0.006, 0.004, -0.005, -0.005, -0.01, 0.004, -0.001, 0.017, -0.001, -0.002, -0.001, -0.002, -0.014, 0.001, -0.001, -0.001, 0.004, 0.013, 0.012, -0.01, -0.01, 0.0, -0.004, -0.004, 0.068, 0.155, -0.033, -0.029, -0.063, 0.011, 0.052, 0.052, -0.071, -0.001, 0.193, -0.101, -0.041, -0.103, -0.085, -0.041, -0.177, -0.099, 0.054, 0.041, -0.017, 0.079, -0.025, -0.026, 0.02, -0.008, -0.009, 0.017, 0.007, -0.012, 0.007, 0.031, -0.018, 0.011, 0.002, 0.002, -0.001, -0.01, 0.019, -0.013, 0.002, -0.005, 0.003, 0.004, 0.004, -0.186, -0.759, 0.197, 0.172, 0.186, -0.094, 0.006, 0.012, 0.0, -0.008, 0.006, 0.007, 0.006, 0.009, 0.004, 0.006, 0.004, 0.004, 0.004, -0.007, 0.001, -0.007, -0.006, 0.014, -0.019, -0.021, 0.005, 0.045, 0.004, 0.001, 0.028, -0.007, 0.028, -0.014, 0.022, 0.036, 0.027, 0.013, 0.004, 0.002, 0.015, -0.009, -0.0, 0.014, 0.006, -0.005, 0.003, 0.002, -0.004, -0.002, 0.002, -0.006, -0.008, -0.014, 0.072, -0.182, 0.022, -0.047, 0.043, 0.025, -0.011, 0.006, -0.04, 0.038, -0.08, -0.01, -0.014, 0.034, 0.008, -0.001, 0.019, -0.013, 0.001, 0.007, 0.016, -0.003, -0.008, 0.002, 0.009, 0.004, -0.007, -0.003, -0.001, 0.006, -0.005, 0.01, -0.005, 0.005, 0.005, -0.003, 0.005, -0.011, 0.084, -0.236, -0.112, 0.034, 0.014, 0.01, -0.048, 0.001, 0.009, 0.009, 0.014, 0.014, 0.03, 0.001, -0.017, -0.014, -0.009, 0.009, -0.004, -0.006, -0.001, 0.006, 0.005, -0.009, 0.0, -0.04, 0.865, 0.59, 0.472, 0.04, 0.077, -0.013, -0.011, -0.043, -0.055, 0.037, 0.004, -0.01, 0.003, 0.006, -0.008, 0.016, -0.008, 0.009, 0.009, -0.017, 0.001, -0.012, 0.018, -0.036, -0.026, 0.008, 0.05, -0.048, 0.004, 0.009, 0.017, 0.001, 0.009, 0.004, 0.002, 0.026, -0.01, 0.075, 0.008, 0.194, -0.388, -0.164, 0.148, 0.015, 0.056, 0.191, 0.107, -0.016, -0.021, 0.004, 0.0, -0.004, -0.006, -0.006, -0.002, 0.007, -0.003, 0.0, -0.001, -0.007, -0.007, -0.005, 0.005, 0.003, 0.002, -0.01, -0.003, 0.007, -0.008, -0.009, -0.001, 0.019, -0.0, -0.002, -0.004, 0.007, -0.004, 0.054, 0.022, -0.033, -0.051, -0.017, 0.17, -0.063, 0.068, 0.009, 0.01, -0.118, -0.222, -0.03, -0.004, 0.121, -0.034, -0.119, -0.174, -0.013, 0.021, -0.071, 0.022, -0.046, -0.007, 0.011, -0.001, -0.007, -0.034, -0.018, 0.001, -0.021, 0.024, 0.019, 0.002, 0.002, -0.014, -0.006, -0.015, 0.006, 0.009, -0.009, -0.01, -0.002, 0.015, -0.002, -0.819, 1.0, 0.217, -0.031, 0.098, 0.021, -0.025, 0.011, -0.019, -0.005, -0.006, -0.009, -0.003, 0.01, -0.006, 0.0, 0.006, 0.003, -0.003, 0.004, 0.006, 0.012, -0.02, 0.005, 0.022, -0.002, 0.012, -0.042, 0.004, -0.02, 0.002, 0.011, 0.045, -0.0, 0.011, 0.024, -0.048, 0.009, -0.001, -0.003, 0.006, 0.036, -0.001, 0.001, 0.0, 0.002, -0.005, -0.008, 0.001, -0.006, 0.015, -0.002, -0.005, -0.01, -0.098, -0.095, 0.07, -0.149, -0.03, 0.028, 0.004, 0.063, 0.006, 0.026, 0.093, -0.011, 0.006, -0.021, -0.056, 0.046, -0.004, 0.0, 0.008, -0.004, -0.001, -0.001, 0.005, -0.003, -0.008, -0.005, 0.001, 0.016, 0.009, 0.011, -0.004, -0.001, -0.012, 0.001, 0.006, 0.005, 0.002, -0.053, 0.043, 0.12, -0.031, 0.066, 0.036, -0.005, 0.031, 0.014, 0.04, -0.01, -0.003, -0.019, 0.021, -0.02, 0.051, -0.03, -0.022, 0.007, -0.005, -0.003, -0.009, 0.008, 0.001, -0.004, -0.05, 0.651, -0.385, 0.104, 0.486, 0.183, -0.032, 0.013, 0.031, 0.05, 0.018, -0.038, -0.005, 0.004, 0.004, 0.0, 0.003, -0.003, 0.001, 0.013, 0.003, -0.007, -0.002, -0.009, -0.006, -0.009, -0.006, -0.004, 0.043, 0.01, -0.022, 0.013, -0.015, -0.016, 0.014, -0.121, -0.095, 0.033, 0.019, -0.014, -0.287, 0.362, 0.491, 0.239, -0.105, 0.153, 0.153, -0.017, -0.055, -0.007, 0.002, -0.01, 0.001, 0.003, 0.009, 0.009, -0.015, -0.01, 0.001, 0.012, 0.003, -0.001, -0.003, -0.011, -0.006, 0.006, -0.001, -0.009, 0.001, -0.0, -0.014, -0.006, 0.004, -0.021, -0.004, 0.007, 0.0, -0.007, 0.011, 0.057, 0.008, -0.02, 0.009, -0.031, 0.013, 0.142, -0.299, -0.011, 0.078, 0.072, 0.109, 0.1, -0.055, -0.065, 0.0, -0.093, 0.036, 0.01, -0.008, -0.027, -0.076, -0.057, -0.009, 0.025, 0.014, -0.0, 0.019, -0.005, -0.023, 0.009, 0.022, 0.061, 0.007, -0.002, 0.008, -0.003, -0.002, -0.015, -0.01, 0.001, 0.001, -0.015, -0.001, 0.009, 0.101, -0.691, 0.313, 0.52, -0.063, 0.0, 0.009, -0.013, -0.002, -0.001, -0.002, -0.004, 0.001, 0.003, -0.004, 0.0, 0.011, -0.013, -0.013, -0.001, 0.005, -0.006, -0.006, 0.001, 0.005, -0.006, 0.003, -0.059, -0.036, -0.052, -0.019, 0.026, -0.003, -0.061, 0.008, -0.005, -0.0, -0.005, -0.005, -0.004, 0.003, -0.007)
    private var amplitudesDB = arrayOf(-0.718, -0.841, -0.841, -0.833, -1.0, -0.841, -1.0, -0.841, -0.9, -1.0, -0.799, -0.767, -0.618, -0.518, -0.355, -0.349, -0.494, -0.574, -0.574, -0.389, -0.754, -0.64, -0.767, -0.443, -0.582, -0.415, -0.741, -0.629, -0.629, -0.841, -1.0, -0.9, -0.841, -0.699, -1.0, -0.841, -0.9, -0.718, -0.699, -0.699, -0.9, -0.9, -1.0, -0.741, -0.77, -1.0, -0.699, -0.718, -0.841, -0.682, -0.481, -0.259, -0.322, -0.428, -0.322, -0.767, -0.396, -1.0, -0.44, -0.449, -0.608, -0.629, -0.481, -1.0, -0.629, -0.49, -1.0, -0.559, -0.841, -0.741, -0.667, -0.767, -1.0, -1.0, -0.9, -0.082, -0.193, -0.091, -0.151, -0.335, -0.528, -0.667, -0.667, -0.523, -0.667, -0.582, -0.841, -0.718, -0.9, -0.699, -1.0, -0.718, -0.667, -1.0, -1.0, -1.0, -0.653, -0.618, -0.629, -0.566, -0.667, -0.9, -0.47, -0.494, -0.682, -0.799, -0.767, -0.799, -0.767, -0.559, -0.328, -0.466, -0.481, -0.44, -0.49, -0.202, -0.518, -0.215, -0.187, -0.206, -0.534, -0.322, -0.64, -0.682, -0.653, -0.699, -0.92, -1.0, -0.767, -0.78, -0.9, -0.699, -0.741, -0.718, -0.697, -0.841, -0.64, -0.682, -0.841, -0.841, -0.841, -1.0, -1.0, -0.841, -1.0, -0.767, -1.0, -0.767, -0.743, -0.733, -0.741, -0.9, -0.699, -0.566, -0.428, -0.508, -0.799, -0.599, -0.481, -0.9, -0.54, -0.308, -0.259, -0.289, -0.653, -0.503, -0.17, -0.241, -0.498, -0.347, -0.415, -0.44, -0.423, -0.508, -0.423, -0.44, -0.699, -0.741, -0.799, -0.582, -0.608, -0.59, -0.599, -0.799, -0.64, -0.9, -0.718, -0.595, -0.608, -0.799, -0.546, -0.741, -0.653, -1.0, -0.64, -1.0, -0.799, -0.9, -0.126, -0.12, -0.371, -0.237, -0.456, -0.718, -0.799, -0.718, -0.718, -1.0, -0.9, -0.767, -0.741, -0.741, -0.841, -0.841, -0.667, -0.9, -0.841, -0.767, -0.767, -0.718, -1.0, -0.767, -0.618, -0.78, -0.741, -1.0, -0.608, -0.799, -0.481, -0.54, -0.653, -0.582, -0.566, -0.59, -0.608, -0.667, -0.9, -0.735, -0.653, -0.599, -0.699, -1.0, -0.699, -1.0, -0.718, -0.741, -1.0, -0.841, -1.0, -0.741, -0.799, -0.767, -0.528, -0.341, -0.608, -0.59, -0.718, -0.534, -0.485, -0.513, -0.682, -0.653, -0.513, -0.667, -0.523, -0.47, -0.682, -0.566, -0.599, -0.699, -0.717, -0.841, -0.9, -0.767, -0.767, -0.9, -0.9, -0.767, -0.841, -0.741, -0.799, -0.841, -0.841, -0.699, -0.741, -0.783, -0.841, -0.718, -0.767, -0.608, -0.362, -0.284, -0.503, -0.566, -0.767, -0.437, -0.528, -0.799, -0.667, -0.667, -0.653, -0.799, -0.503, -0.741, -0.647, -0.64, -0.741, -0.699, -0.799, -1.0, -0.699, -0.699, -0.682, -0.741, -0.841, -0.107, -0.459, -0.546, -0.2, -0.293, -0.608, -0.415, -0.566, -0.608, -0.412, -0.574, -0.799, -0.741, -0.841, -0.9, -0.9, -0.741, -0.767, -0.767, -0.718, -0.653, -0.64, -0.833, -0.841, -0.534, -0.553, -0.566, -0.417, -0.553, -0.64, -0.667, -0.767, -1.0, -0.741, -0.667, -0.443, -0.741, -0.582, -0.608, -0.443, -0.253, -0.175, -0.178, -0.317, -0.379, -0.347, -0.335, -0.462, -0.566, -0.667, -0.9, -1.0, -0.799, -0.799, -0.767, -0.841, -0.841, -0.799, -0.718, -0.841, -1.0, -0.64, -1.0, -1.0, -0.804, -0.9, -0.667, -1.0, -1.0, -1.0, -0.841, -0.682, -0.699, -0.718, -0.718, -0.726, -0.841, -0.841, -0.44, -0.32, -0.54, -0.559, -0.449, -0.699, -0.477, -0.477, -0.431, -1.0, -0.288, -0.381, -0.513, -0.379, -0.405, -0.513, -0.3, -0.385, -0.47, -0.513, -0.64, -0.417, -0.582, -0.582, -0.618, -0.767, -0.718, -0.64, -0.767, -0.682, -0.767, -0.553, -0.629, -0.699, -1.0, -0.9, -1.0, -0.718, -0.629, -0.682, -1.0, -0.799, -0.9, -0.841, -0.841, -0.293, -0.089, -0.285, -0.305, -0.293, -0.391, -0.799, -0.699, -0.884, -0.741, -0.799, -0.767, -0.799, -0.741, -0.841, -0.799, -0.841, -0.841, -0.841, -0.767, -1.0, -0.767, -0.799, -0.667, -0.629, -0.608, -0.799, -0.498, -0.841, -1.0, -0.566, -0.767, -0.566, -0.667, -0.608, -0.528, -0.574, -0.682, -0.841, -1.0, -0.653, -0.741, -0.759, -0.667, -0.799, -0.841, -0.9, -1.0, -0.841, -1.0, -0.9, -0.799, -0.741, -0.667, -0.431, -0.295, -0.599, -0.494, -0.503, -0.582, -0.699, -0.767, -0.518, -0.523, -0.415, -0.718, -0.667, -0.54, -0.741, -1.0, -0.618, -0.682, -1.0, -0.767, -0.653, -0.9, -0.741, -0.9, -0.741, -0.841, -0.767, -0.9, -0.799, -0.799, -0.841, -0.718, -0.841, -0.841, -0.799, -0.9, -0.799, -0.699, -0.407, -0.258, -0.366, -0.54, -0.667, -0.718, -0.49, -0.82, -0.741, -0.718, -0.667, -0.667, -0.559, -1.0, -0.64, -0.667, -0.718, -0.741, -0.841, -0.799, -0.849, -0.799, -0.841, -0.741, -0.833, -0.518, -0.07, -0.126, -0.158, -0.513, -0.42, -0.682, -0.699, -0.503, -0.47, -0.528, -0.841, -0.718, -0.9, -0.799, -0.741, -0.64, -0.741, -0.718, -0.718, -0.64, -1.0, -0.682, -0.629, -0.528, -0.574, -0.741, -0.481, -0.49, -0.841, -0.741, -0.64, -0.859, -0.741, -0.841, -0.9, -0.582, -0.718, -0.425, -0.767, -0.287, -0.186, -0.311, -0.325, -0.653, -0.47, -0.289, -0.373, -0.653, -0.608, -0.841, -0.833, -0.841, -0.799, -0.799, -0.9, -0.767, -0.9, -0.833, -1.0, -0.767, -0.767, -0.841, -0.799, -0.9, -1.0, -0.718, -0.9, -0.767, -0.767, -0.741, -1.0, -0.629, -0.759, -1.0, -0.841, -0.767, -0.841, -0.473, -0.608, -0.546, -0.481, -0.64, -0.306, -0.449, -0.44, -0.718, -0.718, -0.359, -0.267, -0.553, -0.841, -0.355, -0.54, -0.359, -0.302, -0.682, -0.608, -0.431, -0.599, -0.494, -0.767, -0.699, -0.95, -0.767, -0.54, -0.629, -0.709, -0.608, -0.59, -0.629, -1.0, -0.9, -0.667, -0.799, -0.653, -0.767, -0.741, -0.741, -0.718, -1.0, -0.653, -0.9, -0.078, -0.049, -0.271, -0.553, -0.385, -0.608, -0.582, -0.699, -0.629, -0.799, -0.799, -0.718, -0.9, -0.718, -0.799, -0.849, -0.799, -0.9, -0.9, -0.841, -0.767, -0.682, -0.618, -0.799, -0.599, -0.9, -0.682, -0.508, -0.841, -0.618, -1.0, -0.699, -0.498, -0.743, -0.699, -0.59, -0.49, -0.741, -1.0, -0.9, -0.799, -0.534, -1.0, -1.0, -0.754, -0.9, -0.799, -0.741, -1.0, -0.799, -0.653, -1.0, -0.799, -0.718, -0.385, -0.389, -0.434, -0.325, -0.559, -0.566, -0.841, -0.449, -0.767, -0.574, -0.393, -0.699, -0.799, -0.608, -0.47, -0.494, -0.841, -0.783, -0.741, -0.841, -1.0, -0.724, -0.841, -0.9, -0.767, -0.841, -1.0, -0.653, -0.741, -0.699, -0.841, -1.0, -0.682, -1.0, -0.799, -0.841, -1.0, -0.477, -0.503, -0.357, -0.553, -0.443, -0.528, -0.799, -0.553, -0.667, -0.518, -0.718, -0.9, -0.629, -0.608, -0.618, -0.481, -0.559, -0.599, -0.767, -0.799, -0.9, -0.741, -0.767, -1.0, -0.841, -0.481, -0.111, -0.187, -0.377, -0.154, -0.295, -0.546, -0.682, -0.553, -0.481, -0.629, -0.523, -0.841, -0.841, -0.841, -0.741, -0.9, -0.9, -1.0, -0.682, -0.9, -0.767, -1.0, -0.741, -0.799, -0.741, -0.799, -0.841, -0.503, -0.718, -0.599, -0.682, -0.653, -0.653, -0.667, -0.355, -0.389, -0.54, -0.629, -0.667, -0.23, -0.197, -0.152, -0.257, -0.375, -0.321, -0.321, -0.64, -0.47, -0.767, -1.0, -0.718, -1.0, -0.9, -0.718, -0.741, -0.667, -0.718, -1.0, -0.682, -0.9, -1.0, -0.9, -0.699, -0.767, -0.799, -1.0, -0.741, -1.0, -1.0, -0.667, -0.799, -0.841, -0.608, -0.841, -0.767, -0.77, -0.767, -0.699, -0.466, -0.767, -0.618, -0.741, -0.553, -0.682, -0.332, -0.224, -0.699, -0.42, -0.431, -0.369, -0.383, -0.47, -0.446, -0.553, -0.393, -0.528, -0.718, -0.767, -0.574, -0.423, -0.462, -0.718, -0.582, -0.667, -0.754, -0.629, -0.799, -0.59, -0.741, -0.608, -0.456, -0.767, -1.0, -0.741, -0.9, -1.0, -0.653, -0.718, -0.9, -1.0, -0.667, -0.92, -0.741, -0.381, -0.103, -0.218, -0.144, -0.449, -0.7, -0.741, -0.682, -1.0, -1.0, -1.0, -0.841, -0.833, -0.9, -0.841, -0.82, -0.699, -0.682, -0.682, -1.0, -0.841, -0.799, -0.799, -0.804, -0.799, -0.799, -0.9, -0.459, -0.528, -0.477, -0.618, -0.574, -0.9, -0.456, -0.741, -0.799, -0.743, -0.841, -0.799, -0.841, -0.9, -0.767)
    private var amplitudesAttenuated = arrayOf(-0.071, 0.03, 0.03, 0.0, 0.01, -0.03, 0.01, -0.03, -0.02, -0.01, 0.04, 0.051, 0.141, -0.283, 0.869, 0.909, 0.333, -0.192, -0.192, -0.687, -0.0, -0.121, 0.051, -0.475, 0.182, -0.576, 0.061, 0.131, -0.131, -0.03, -0.01, -0.02, 0.03, 0.081, 0.01, -0.03, 0.02, 0.071, 0.081, -0.081, -0.02, 0.02, -0.01, -0.061, 0.0, 0.01, -0.081, -0.071, 0.03, 0.091, -0.364, 0.169, 0.109, -0.525, -0.109, -0.051, 0.657, 0.01, -0.485, -0.455, -0.152, -0.131, 0.364, 0.01, -0.131, 0.343, 0.01, -0.212, -0.03, 0.061, -0.101, 0.051, -0.01, 0.01, 0.0, -0.574, -0.267, 0.538, -0.357, -1.0, -0.263, -0.101, 0.101, 0.273, -0.101, -0.182, -0.03, -0.071, 0.02, -0.081, -0.01, -0.071, -0.101, 0.01, -0.01, -0.01, 0.111, -0.141, -0.131, 0.202, 0.101, 0.02, -0.394, -0.333, -0.091, 0.04, 0.051, -0.04, 0.051, -0.212, 0.105, 0.404, -0.364, 0.485, 0.343, 0.249, 0.283, -0.229, 0.278, 0.243, 0.253, 0.109, -0.121, -0.091, 0.111, -0.081, -0.0, -0.01, 0.051, 0.0, -0.02, -0.081, -0.061, -0.071, -0.0, -0.03, 0.121, 0.091, 0.03, 0.03, 0.03, 0.01, -0.01, 0.03, 0.01, 0.051, 0.01, -0.051, -0.0, -0.0, -0.061, -0.02, 0.081, 0.202, 0.525, 0.303, -0.04, 0.162, 0.364, -0.02, 0.0, 0.12, 0.169, -0.137, -0.111, -0.313, 0.312, -0.191, 0.323, -0.919, -0.576, 0.485, -0.545, 0.303, 0.545, 0.485, 0.081, -0.061, 0.04, 0.182, 0.152, 0.172, 0.162, -0.04, -0.121, 0.02, -0.071, 0.0, -0.152, -0.04, 0.232, 0.061, 0.111, -0.01, -0.121, 0.01, 0.04, -0.02, 0.422, -0.441, -0.778, -0.197, -0.434, -0.071, -0.04, -0.071, 0.071, -0.01, -0.02, -0.051, 0.061, 0.061, -0.03, 0.03, 0.101, -0.02, 0.03, -0.051, 0.051, 0.071, 0.01, -0.051, 0.141, -0.0, -0.061, 0.01, -0.152, 0.04, -0.364, 0.242, -0.111, 0.182, -0.202, -0.172, 0.152, -0.101, -0.02, -0.0, -0.111, 0.162, 0.081, -0.01, 0.081, -0.01, -0.071, 0.061, -0.01, 0.03, 0.01, -0.061, 0.04, -0.051, 0.263, -0.96, -0.152, 0.172, -0.071, -0.253, -0.354, 0.293, 0.091, -0.111, 0.293, -0.101, 0.273, -0.394, -0.091, 0.202, 0.162, -0.081, 0.0, 0.03, 0.02, -0.051, 0.051, -0.02, 0.0, -0.051, -0.03, -0.061, 0.04, -0.03, -0.03, -0.081, 0.061, 0.0, 0.03, -0.071, 0.051, -0.152, 0.828, -0.142, 0.313, 0.202, -0.051, -0.495, -0.263, -0.04, 0.101, -0.101, 0.111, 0.04, -0.313, -0.061, 0.0, -0.121, -0.061, -0.081, -0.04, -0.01, -0.081, 0.081, -0.091, 0.061, 0.0, 0.484, 0.424, -0.232, -0.254, 0.133, -0.152, 0.576, -0.202, -0.152, 0.586, -0.192, -0.04, -0.061, 0.03, -0.02, 0.02, 0.061, 0.051, 0.051, -0.071, -0.111, 0.121, 0.0, 0.03, 0.253, 0.222, -0.202, -0.566, 0.222, -0.121, -0.101, 0.051, 0.01, 0.061, 0.101, 0.475, 0.061, -0.182, -0.152, -0.475, -0.176, 0.301, 0.295, -0.113, -0.737, 0.919, 1.0, -0.414, 0.202, -0.101, 0.02, 0.01, -0.04, 0.04, -0.051, 0.03, -0.03, -0.04, -0.071, 0.03, -0.01, 0.121, -0.01, -0.01, -0.0, -0.02, -0.101, 0.01, -0.01, -0.01, 0.03, 0.091, 0.081, -0.071, -0.071, 0.0, -0.03, -0.03, 0.485, 0.111, -0.242, -0.212, -0.455, 0.081, 0.374, 0.374, -0.515, -0.01, 0.138, -0.727, -0.293, -0.737, -0.616, -0.293, -0.127, -0.707, 0.394, 0.293, -0.121, 0.566, -0.182, -0.182, 0.141, -0.051, -0.071, 0.121, 0.051, -0.091, 0.051, 0.222, -0.131, 0.081, 0.01, 0.02, -0.01, -0.071, 0.131, -0.091, 0.01, -0.04, 0.02, 0.03, 0.03, -0.133, -0.545, 0.141, 0.123, 0.133, -0.677, 0.04, 0.081, 0.0, -0.061, 0.04, 0.051, 0.04, 0.061, 0.03, 0.04, 0.03, 0.03, 0.03, -0.051, 0.01, -0.051, -0.04, 0.101, -0.131, -0.152, 0.04, 0.323, 0.03, 0.01, 0.202, -0.051, 0.202, -0.101, 0.152, 0.263, 0.192, 0.091, 0.03, 0.01, 0.111, -0.061, -0.0, 0.101, 0.04, -0.03, 0.02, 0.01, -0.03, -0.01, 0.02, -0.04, -0.061, -0.101, 0.515, -0.131, 0.162, -0.333, 0.313, 0.182, -0.081, 0.051, -0.283, 0.273, -0.576, -0.071, -0.101, 0.242, 0.061, -0.01, 0.141, -0.091, 0.01, 0.051, 0.111, -0.02, -0.061, 0.02, 0.061, 0.03, -0.051, -0.02, -0.0, 0.04, -0.03, 0.071, -0.03, 0.03, 0.04, -0.02, 0.04, -0.081, 0.606, -0.17, -0.808, 0.242, 0.101, 0.071, -0.343, 0.0, 0.061, 0.071, 0.101, 0.101, 0.212, 0.01, -0.121, -0.101, -0.071, 0.061, -0.03, -0.04, -0.0, 0.04, 0.03, -0.061, 0.0, -0.283, 0.621, 0.423, 0.339, 0.293, 0.556, -0.091, -0.081, -0.313, -0.394, 0.263, 0.03, -0.071, 0.02, 0.04, -0.061, 0.121, -0.061, 0.071, 0.071, -0.121, 0.01, -0.091, 0.131, -0.263, -0.192, 0.061, 0.364, -0.343, 0.03, 0.061, 0.121, 0.0, 0.061, 0.03, 0.02, 0.182, -0.071, 0.535, 0.051, 0.139, -0.279, -0.118, 0.107, 0.111, 0.394, 0.137, 0.768, -0.111, -0.152, 0.03, 0.0, -0.03, -0.04, -0.04, -0.02, 0.051, -0.02, 0.0, -0.01, -0.051, -0.051, -0.03, 0.04, 0.02, 0.01, -0.071, -0.02, 0.051, -0.051, -0.061, -0.01, 0.131, -0.0, -0.01, -0.03, 0.051, -0.03, 0.384, 0.152, -0.232, -0.364, -0.121, 0.122, -0.455, 0.485, 0.071, 0.071, -0.848, -0.16, -0.222, -0.03, 0.869, -0.242, -0.848, -0.125, -0.091, 0.152, -0.515, 0.162, -0.333, -0.051, 0.081, -0.0, -0.051, -0.242, -0.131, 0.0, -0.152, 0.172, 0.131, 0.01, 0.02, -0.101, -0.04, -0.111, 0.051, 0.061, -0.061, -0.071, -0.01, 0.111, -0.02, -0.589, 0.718, 0.156, -0.222, 0.707, 0.152, -0.182, 0.081, -0.131, -0.04, -0.04, -0.071, -0.02, 0.071, -0.04, 0.0, 0.04, 0.02, -0.02, 0.03, 0.051, 0.091, -0.141, 0.04, 0.162, -0.02, 0.091, -0.303, 0.03, -0.141, 0.01, 0.081, 0.323, -0.0, 0.081, 0.172, -0.343, 0.061, -0.01, -0.02, 0.04, 0.253, -0.01, 0.01, 0.0, 0.02, -0.04, -0.061, 0.01, -0.04, 0.111, -0.01, -0.04, -0.071, -0.707, -0.687, 0.505, -0.107, -0.212, 0.202, 0.03, 0.455, 0.051, 0.192, 0.667, -0.081, 0.04, -0.152, -0.394, 0.333, -0.03, 0.0, 0.061, -0.03, -0.01, -0.0, 0.03, -0.02, -0.051, -0.03, 0.01, 0.111, 0.061, 0.081, -0.03, -0.01, -0.091, 0.01, 0.04, 0.03, 0.01, -0.374, 0.313, 0.859, -0.222, 0.475, 0.263, -0.04, 0.222, 0.101, 0.283, -0.071, -0.02, -0.131, 0.152, -0.141, 0.364, -0.212, -0.162, 0.051, -0.04, -0.02, -0.061, 0.051, 0.01, -0.03, -0.364, 0.468, -0.277, 0.747, 0.349, 0.131, -0.232, 0.091, 0.222, 0.364, 0.131, -0.273, -0.03, 0.03, 0.03, 0.0, 0.02, -0.02, 0.01, 0.091, 0.02, -0.051, -0.01, -0.061, -0.04, -0.061, -0.04, -0.03, 0.313, 0.071, -0.162, 0.091, -0.111, -0.111, 0.101, -0.869, -0.687, 0.242, 0.131, -0.101, -0.206, 0.26, 0.353, 0.172, -0.758, 0.11, 0.11, -0.121, -0.394, -0.051, 0.01, -0.071, 0.01, 0.02, 0.071, 0.061, -0.101, -0.071, 0.01, 0.091, 0.02, -0.01, -0.02, -0.081, -0.051, 0.04, -0.01, -0.061, 0.01, -0.0, -0.101, -0.04, 0.03, -0.152, -0.03, 0.051, 0.0, -0.051, 0.081, 0.404, 0.051, -0.141, 0.061, -0.222, 0.091, 0.102, -0.215, -0.081, 0.556, 0.515, 0.788, 0.717, -0.394, -0.465, 0.0, -0.667, 0.263, 0.071, -0.051, -0.192, -0.545, -0.414, -0.071, 0.182, 0.101, -0.0, 0.131, -0.04, -0.172, 0.061, 0.152, 0.434, 0.051, -0.01, 0.061, -0.02, -0.01, -0.111, -0.071, 0.0, 0.01, -0.101, -0.0, 0.061, 0.727, -0.497, 0.224, 0.374, -0.455, 0.0, 0.061, -0.091, -0.01, -0.01, -0.01, -0.03, 0.0, 0.02, -0.03, 0.0, 0.081, -0.091, -0.091, -0.01, 0.03, -0.04, -0.04, 0.0, 0.04, -0.04, 0.02, -0.424, -0.263, -0.374, -0.141, 0.192, -0.02, -0.434, 0.061, -0.04, -0.0, -0.03, -0.04, -0.03, 0.02, -0.051)
    private var amplitudesLonger = arrayOf(-0.609, 0.782, -0.971, -0.959, 0.369, -0.949, -0.915, 0.846, -0.334, 0.267, -0.123, 0.757, -0.165, 0.339, -0.19, 0.843, -0.757, -0.826, 0.573, -0.805, -0.705, 0.808, -0.086, 0.404, -0.276, 0.569, -0.274, 0.393, -0.068, 0.744, -0.623, -0.703, 0.515, -0.691, -0.608, 0.689, -0.108, 0.297, -0.174, 0.539, -0.145, 0.234, -0.174, 0.596, -0.59, -0.619, 0.301, -0.603, -0.58, 0.502, -0.287, 0.03, 0.083, 0.543, 0.125, -0.062, -0.368, 0.33, -0.503, -0.433, -0.036, -0.39, -0.44, 0.168, -0.431, -0.276, 0.341, 0.372, 0.361, -0.334, -0.413, -0.063, -0.197, -0.057, -0.314, 0.002, -0.079, -0.204, -0.283, -0.337, 0.312, -0.016, 0.274, -0.275, -0.125, -0.279, 0.17, 0.237, -0.215, 0.243, 0.214, -0.226, 0.079, -0.029, -0.024, -0.204, -0.064, 0.057, 0.153, -0.061, 0.14, 0.085, 0.081, 0.046, 0.067, -0.042, 0.012, -0.001, 0.0, 0.0, 0.0, 0.0, -0.0, 0.0, 0.0, -0.0, -0.0, -0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.0, -0.0, 0.0, 0.0, -0.0, -0.0, 0.0, -0.0, 0.0, 0.0, -0.0, -0.0, -0.0, 0.0, 0.0, 0.0, -0.0, -0.0, 0.0, -0.0, 0.0, 0.0, 0.0, 0.0, -0.0, 0.0, 0.0, -0.0, 0.0, 0.0, -0.0, -0.0, 0.0, -0.0, 0.0, 0.0, -0.0, -0.0, 0.0, -0.0, 0.0, 0.0, -0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.0, -0.0, 0.0, 0.0, 0.0, 0.0, -0.0, -0.0, 0.0, 0.0, -0.0, 0.0, -0.0, 0.0, 0.0, -0.0, -0.0, -0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.0, -0.0, 0.0, 0.0, -0.0, -0.0, 0.0, -0.0, 0.0, 0.0, -0.0, 0.17, 0.004, 0.0, -0.0, 0.0, 0.0, -0.0, 0.0, -0.0, -0.0, 0.0, 0.0, 0.0, 0.0, -0.0, 0.0, 0.0, -0.0, 0.0, 0.0, 0.0, 0.0, -0.0, -0.0, 0.0, 0.0, -0.0, -0.0, -0.0, -0.0, -0.0, 0.0, -0.0, -0.0, 0.0, -0.0, 0.0, 0.0, -0.0, -0.0, -0.0, -0.0, 0.0, 0.0, -0.0, -0.0, 0.0, 0.0, -0.0, 0.0, 0.0, -0.0, 0.0, 0.0, 0.0, -0.0, -0.0, -0.0, 0.0, -0.0, 0.0, 0.0, 0.0, -0.0, 0.0, 0.0, -0.0, 0.0, -0.0, -0.0, -0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.0, 0.0, -0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.0, -0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.0, 0.0, 0.0, -0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.0, -0.042, 0.0, 0.0, -0.0, 0.0, 0.0, -0.0, -0.0, -0.0, 0.0, 0.0, 0.0, -0.0, -0.0, -0.0, -0.0, -0.0, 0.0, 0.0, -0.0, -0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.0, 0.0, -0.0, 0.0, 0.0, -0.0, 0.0, 0.0, -0.0, 0.0, 0.0, -0.0, 0.0, -0.0, 0.0, 0.0, 0.0, -0.0, -0.0, 0.0, -0.0, -0.0, -0.0, -0.0, 0.0, 0.0, 0.0, 0.0, -0.0, 0.0, -0.0, 0.0, 0.0, 0.0, 0.0, -0.0, 0.0, 0.0, -0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.0, 0.0, 0.0, -0.0, -0.0, 0.0, -0.0, 0.0, 0.0, -0.0, -0.0, -0.0, 0.0, -0.0, 0.0, 0.0, 0.0, -0.0, 0.0, 0.0, -0.0, 0.0, 0.0, 0.017, 0.005, -0.0)
    private lateinit var playerController: DefaultPlayerController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val playerView = findViewById<PlayerView>(R.id.player_view)
        playerController = DefaultPlayerController(playerView).apply {
            setListener(play = {
                Toast.makeText(
                    this@MainActivity,
                    "Play Clicked !",
                    Toast.LENGTH_SHORT
                ).show()})
        }
        val uri = Uri.parse("android.resource://$packageName/raw/france")
        try {
            playerController.addAudioFileUri(applicationContext, uri,amplitudesDB)
            //view.addAudioUrl(url,amplitudes)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        playerController.destroyPlayer()
    }
}