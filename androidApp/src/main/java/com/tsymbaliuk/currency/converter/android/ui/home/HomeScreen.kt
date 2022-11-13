package com.tsymbaliuk.currency.converter.android.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.tsymbaliuk.currency.converter.android.ui.theme.AppColors

@Preview
@Composable
fun HomeScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.primary)
    ) {
        val (backLayer, swapButton, frontLayer) = createRefs()
        val middleGuideline = createGuidelineFromTop(0.5f)

        BackLayerContent(
            modifier = Modifier
                .constrainAs(
                    ref = backLayer,
                    constrainBlock = {
                        height = Dimension.fillToConstraints
                        width = Dimension.matchParent
                        top.linkTo(parent.top)
                        bottom.linkTo(middleGuideline)
                    })
        )

        FrontLayerContent(
            modifier = Modifier
                .constrainAs(
                    ref = frontLayer,
                    constrainBlock = {
                        height = Dimension.fillToConstraints
                        width = Dimension.matchParent
                        top.linkTo(middleGuideline)
                        bottom.linkTo(parent.bottom)
                    })
        )

        SwapButton(
            modifier = Modifier
                .constrainAs(
                    ref = swapButton,
                    constrainBlock = {
                        top.linkTo(middleGuideline)
                        end.linkTo(parent.end)
                        bottom.linkTo(middleGuideline)
                    }
                )
        )
    }

}