package jsalt;

import static org.junit.Assert.assertEquals;
import jsalt.SaltedHashGenerator;
import jsalt.StandardJSEAlgorithms;

import org.junit.Test;


public class SaltedHashGeneratorTest {
	

	@Test
	public void testEncodePassword() {
		assertEquals("8d2fb9e038dcf30c8eb1ce1dfae66cc4", new SaltedHashGenerator("MD2").encodePassword("pass1", "salt0"));
		assertEquals("33f1619893155b53760a255de530b9ee", new SaltedHashGenerator("MD5").encodePassword("pass2", "salt9"));
		assertEquals("a5044c8efaee1df1a56ee67340492004cd18649c", new SaltedHashGenerator("SHA-1").encodePassword("pass3", "salt8"));
		assertEquals("30e19556c4711a2809fef8cf84d5770c0498f06d45602dfdaae2712ed5028157", new SaltedHashGenerator("SHA-256").encodePassword("pass4", "salt7"));
		assertEquals("78dd9377a2a90a9dc743d378fe131a140147dbf77aa133b1b38e1e2aed42acfedf7e226eb182036e7ba33a960aa9d609", new SaltedHashGenerator("SHA-384").encodePassword("pass4", "salt7"));
		assertEquals("5b2c71587861b27e73740db8268728a149d77213657077dd99233ea677baf863ebcf350a967ffc565b3f385cf9a3a476a6f2f0778801974c61b9a822a1ba1a06", new SaltedHashGenerator("SHA-512").encodePassword("pass5", "salt6"));
		assertEquals("8d2fb9e038dcf30c8eb1ce1dfae66cc4", new SaltedHashGenerator("MD2", false).encodePassword("pass1", "salt0"));
		assertEquals("33f1619893155b53760a255de530b9ee", new SaltedHashGenerator("MD5", false).encodePassword("pass2", "salt9"));
		assertEquals("a5044c8efaee1df1a56ee67340492004cd18649c", new SaltedHashGenerator("SHA-1", false).encodePassword("pass3", "salt8"));
		assertEquals("30e19556c4711a2809fef8cf84d5770c0498f06d45602dfdaae2712ed5028157", new SaltedHashGenerator("SHA-256", false).encodePassword("pass4", "salt7"));
		assertEquals("78dd9377a2a90a9dc743d378fe131a140147dbf77aa133b1b38e1e2aed42acfedf7e226eb182036e7ba33a960aa9d609", new SaltedHashGenerator("SHA-384", false).encodePassword("pass4", "salt7"));
		assertEquals("5b2c71587861b27e73740db8268728a149d77213657077dd99233ea677baf863ebcf350a967ffc565b3f385cf9a3a476a6f2f0778801974c61b9a822a1ba1a06", new SaltedHashGenerator("SHA-512", false).encodePassword("pass5", "salt6"));
		assertEquals("SR5leiXVUyjBEJ45oZe4Mg==", new SaltedHashGenerator("MD2", true).encodePassword("pass", "salt"));
		assertEquals("MxpLvlZfq7CGQIi8aX8dXA==", new SaltedHashGenerator("MD5", true).encodePassword("pass0", "salt5"));
		assertEquals("IiCxYRbMg6H8Gc0Tdv9cPtJ1+0Q=", new SaltedHashGenerator("SHA-1", true).encodePassword("pass1", "salt6"));
		assertEquals("pze914XS3noUelt7xzi1diHMtoD9c9jjRvP2jesntOs=", new SaltedHashGenerator("SHA-256", true).encodePassword("pass2", "salt7"));
		assertEquals("XjxGG/GXfR79Elm3dTf2z68BqXPH3RWiiSHUNR3wgGGdTgpa5UCGlq2P/z663ye0", new SaltedHashGenerator("SHA-384", true).encodePassword("pass3", "salt8"));
		assertEquals("0TsTxAA80nuJ+OMGWUEG9uhCB1lo+o/aor7q+wI3DCNxTWoDiCImlC135uigllvPlT+6OqhgG/RZx2z3t/W7tw==", new SaltedHashGenerator("SHA-512", true).encodePassword("pass4", "salt9"));
		assertEquals("491e657a25d55328c1109e39a197b832", new SaltedHashGenerator(StandardJSEAlgorithms.MD2).encodePassword("pass", "salt"));
		assertEquals("331a4bbe565fabb0864088bc697f1d5c", new SaltedHashGenerator(StandardJSEAlgorithms.MD5).encodePassword("pass0", "salt5"));
		assertEquals("2220b16116cc83a1fc19cd1376ff5c3ed275fb44", new SaltedHashGenerator(StandardJSEAlgorithms.SHA1).encodePassword("pass1", "salt6"));
		assertEquals("a737bdd785d2de7a147a5b7bc738b57621ccb680fd73d8e346f3f68deb27b4eb", new SaltedHashGenerator(StandardJSEAlgorithms.SHA256).encodePassword("pass2", "salt7"));
		assertEquals("5e3c461bf1977d1efd1259b77537f6cfaf01a973c7dd15a28921d4351df080619d4e0a5ae5408696ad8fff3ebadf27b4", new SaltedHashGenerator(StandardJSEAlgorithms.SHA384).encodePassword("pass3", "salt8"));
		assertEquals("d13b13c4003cd27b89f8e306594106f6e842075968fa8fdaa2beeafb02370c23714d6a03882226942d77e6e8a0965bcf953fba3aa8601bf459c76cf7b7f5bbb7", new SaltedHashGenerator(StandardJSEAlgorithms.SHA512).encodePassword("pass4", "salt9"));
		assertEquals("491e657a25d55328c1109e39a197b832", new SaltedHashGenerator(StandardJSEAlgorithms.MD2, false).encodePassword("pass", "salt"));
		assertEquals("331a4bbe565fabb0864088bc697f1d5c", new SaltedHashGenerator(StandardJSEAlgorithms.MD5, false).encodePassword("pass0", "salt5"));
		assertEquals("2220b16116cc83a1fc19cd1376ff5c3ed275fb44", new SaltedHashGenerator(StandardJSEAlgorithms.SHA1, false).encodePassword("pass1", "salt6"));
		assertEquals("a737bdd785d2de7a147a5b7bc738b57621ccb680fd73d8e346f3f68deb27b4eb", new SaltedHashGenerator(StandardJSEAlgorithms.SHA256, false).encodePassword("pass2", "salt7"));
		assertEquals("5e3c461bf1977d1efd1259b77537f6cfaf01a973c7dd15a28921d4351df080619d4e0a5ae5408696ad8fff3ebadf27b4", new SaltedHashGenerator(StandardJSEAlgorithms.SHA384, false).encodePassword("pass3", "salt8"));
		assertEquals("d13b13c4003cd27b89f8e306594106f6e842075968fa8fdaa2beeafb02370c23714d6a03882226942d77e6e8a0965bcf953fba3aa8601bf459c76cf7b7f5bbb7", new SaltedHashGenerator(StandardJSEAlgorithms.SHA512, false).encodePassword("pass4", "salt9"));
		assertEquals("SR5leiXVUyjBEJ45oZe4Mg==", new SaltedHashGenerator(StandardJSEAlgorithms.MD2, true).encodePassword("pass", "salt"));
		assertEquals("MxpLvlZfq7CGQIi8aX8dXA==", new SaltedHashGenerator(StandardJSEAlgorithms.MD5, true).encodePassword("pass0", "salt5"));
		assertEquals("IiCxYRbMg6H8Gc0Tdv9cPtJ1+0Q=", new SaltedHashGenerator(StandardJSEAlgorithms.SHA1, true).encodePassword("pass1", "salt6"));
		assertEquals("pze914XS3noUelt7xzi1diHMtoD9c9jjRvP2jesntOs=", new SaltedHashGenerator(StandardJSEAlgorithms.SHA256, true).encodePassword("pass2", "salt7"));
		assertEquals("XjxGG/GXfR79Elm3dTf2z68BqXPH3RWiiSHUNR3wgGGdTgpa5UCGlq2P/z663ye0", new SaltedHashGenerator(StandardJSEAlgorithms.SHA384, true).encodePassword("pass3", "salt8"));
		assertEquals("0TsTxAA80nuJ+OMGWUEG9uhCB1lo+o/aor7q+wI3DCNxTWoDiCImlC135uigllvPlT+6OqhgG/RZx2z3t/W7tw==", new SaltedHashGenerator(StandardJSEAlgorithms.SHA512, true).encodePassword("pass4", "salt9"));
	}

}
