package com.jimmy.poseestimation;

import ai.fritz.core.Fritz;
import ai.fritz.poseestimationmodel.PoseEstimationOnDeviceModel;
import ai.fritz.vision.FritzVision;
import ai.fritz.vision.FritzVisionImage;
import ai.fritz.vision.FritzVisionOrientation;
import ai.fritz.vision.poseestimation.FritzVisionPosePredictor;
import ai.fritz.vision.poseestimation.FritzVisionPoseResult;
import android.graphics.Canvas;
import android.media.Image;
import android.util.Size;

public class MainActivity extends ai.fritz.camera.LiveCameraActivity {

    private static final String API_KEY = "efb0191f3c5242ed8f836f5d4abd91dd";

    FritzVisionPosePredictor predictor;
    FritzVisionImage visionImage;
    FritzVisionPoseResult poseResult;

    @Override
    protected void initializeFritz() {
        // TODO: Uncomment this and modify your api key above.
        Fritz.configure(this, API_KEY);
    }

    @Override
    protected void setupPredictor() {
        // STEP 1: Get the predictor and set the options.
        // ----------------------------------------------
        // A FritzOnDeviceModel object is available when a model has been
        // successfully downloaded and included with the app.
        PoseEstimationOnDeviceModel poseEstimationOnDeviceModel = new PoseEstimationOnDeviceModel();
        predictor = FritzVision.PoseEstimation.getPredictor(poseEstimationOnDeviceModel);

        // ----------------------------------------------
        // END STEP 1
    }

    @Override
    protected void setupImageForPrediction(Image image) {
        // Set the rotation
        int imageRotation = FritzVisionOrientation.getImageRotationFromCamera(this, cameraId);
        // STEP 2: Create the FritzVisionImage object from media.Image
        // ------------------------------------------------------------------------
        visionImage = FritzVisionImage.fromMediaImage(image, imageRotation);
        // ------------------------------------------------------------------------
        // END STEP 2
    }

    @Override
    protected void runInference() {
        // STEP 3: Run predict on the image
        // ---------------------------------------------------
        poseResult = predictor.predict(visionImage);
        // ----------------------------------------------------
        // END STEP 3
    }

    @Override
    protected void showResult(Canvas canvas, Size cameraSize) {
        // STEP 4: Draw the prediction result
        // ----------------------------------
        if(poseResult != null) {
            poseResult.drawPoses(canvas, cameraSize);
        }
        // ----------------------------------
        // END STEP 4
    }
}
