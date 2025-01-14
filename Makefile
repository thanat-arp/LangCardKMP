publish-ios:
	./gradlew assembleLangCardImageXCFramework
	cp -rf ../lang-card-kmp/LangCardImage/build/XCFrameworks/release/LangCardImage.xcframework ../LangCardiOS/


publish-android:   
	./gradlew publishKotlinMultiplatformPublicationToGitHubPackagesRepository publishAndroidDebugPublicationToGitHubPackagesRepository publishAndroidReleasePublicationToGitHubPackagesRepository
