import { useEffect, useRef } from "react"
import * as THREE from "three"

export default function VantaBackground() {
  const vantaRef = useRef<HTMLDivElement | null>(null)
  const effectRef = useRef<{ destroy: () => void } | null>(null)

  useEffect(() => {
    ;(window as any).THREE = THREE

    import("vanta/dist/vanta.waves.min").then(() => {
      const WAVES = (window as any).VANTA?.WAVES
      if (!vantaRef.current || typeof WAVES !== "function") return

      effectRef.current = WAVES({
        el: vantaRef.current,
        THREE,
        forceAnimate: true,
        mouseControls: false,
        touchControls: false,
        gyroControls: false,
        minHeight: 200,
        minWidth: 200,
        scale: 1,
        scaleMobile: 1,
        color: 0x2f2f2f,
        backgroundColor: 0x111827,
        waveHeight: 20,
        waveSpeed: 1.1,
        shininess: 30,
      })
    })

    return () => {
      effectRef.current?.destroy()
      effectRef.current = null
    }
  }, [])

  return <div ref={vantaRef} style={{ width: "100%", minHeight: "100vh" }} className="vanta-background" />
}